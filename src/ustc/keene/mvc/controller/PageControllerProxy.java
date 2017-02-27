package ustc.keene.mvc.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ustc.keene.mvc.controller.interceptor.IInterceptor;
import ustc.keene.mvc.tools.ConstantValues;
import ustc.keene.mvc.tools.ExceptionThrower;

/**
 * @author keene C. zhu
 * 
 *         该代码遵循Apache License Version 2.0, January
 *         2004。详细见http://www.apache.org/licenses/
 * 
 *         Copyright {2015-2017} {keene C. zhu}
 * 
 *         designed by keene, implemented by {coder name}
 * 
 *         该类是PageController的代理，用于接收FrontController分发的请求，实现拦截器调用及调用目标页面控制器功能
 * 
 */
public class PageControllerProxy implements IPageController {

	/**
	 * targetPageController为目标页面控制器
	 */
	private IPageController targetPageController;

	/**
	 * interceptors存放targetPageController配置的所有拦截器
	 */
	private List<IInterceptor> interceptors;

	/**
	 * targetControllerDescriptor存放目标页面控制器描述信息
	 */
	private PageControllerDescriptor targetControllerDescriptor;

	public PageControllerProxy(PageControllerDescriptor pcd) {
		targetControllerDescriptor = pcd;
		initProxy();
	}

	/**
	 * 初始化PageControllerProxy
	 */
	public void initProxy() {
		interceptors = new ArrayList<IInterceptor>();
		List<String> interceptorNames = targetControllerDescriptor.getInterceptorsList();
		for (String name : interceptorNames) {
			IInterceptor interceptor = ControllerConfiguration.getInstance().findInterceptor(name);
			ExceptionThrower.throwInterceptorNotFoundException(interceptor);
			interceptors.add(interceptor);
		}
		try {
			targetPageController = (IPageController) Class.forName(targetControllerDescriptor.getClassName())
					.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ustc.keene.sc.controller.ISCPageController#handle()
	 */
	@Override
	public String handle(PageControllerContext context) {

		// 进行拦截器predo的调用
		for (IInterceptor i : interceptors) {
			i.preDo(context);
		}
		/**
		 * 调用目标页面控制器，实现请求逻辑处理
		 */
		String result = null;

		if (targetControllerDescriptor.getMethodName().equals(ConstantValues.DEFAULTCONTROLLERMETHOD)) {
			result = targetPageController.handle(context);
		} else {
			Method m = null;
			try {
				m = Class.forName(targetControllerDescriptor.getClassName()).getMethod(targetControllerDescriptor.getMethodName(), null);
			} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				result = (String) m.invoke(targetPageController, null);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 进行拦截器afterDo的调用
		for (IInterceptor i : interceptors) {
			i.afterDo(context);
		}
		return result;
	}

}
