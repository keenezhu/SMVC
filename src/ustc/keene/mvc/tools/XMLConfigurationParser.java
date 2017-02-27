package ustc.keene.mvc.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Element;

import ustc.keene.mvc.controller.ControllerConfiguration;
import ustc.keene.mvc.controller.PageControllerDescriptor;
import ustc.keene.mvc.controller.interceptor.IInterceptor;
import ustc.keene.mvc.controller.result.ResultDescriptor;

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
 *         该类负责使用Dom4j解析配置文件controller.xml
 */
public class XMLConfigurationParser implements IConfigurationAdapter {

	@Override
	public void getCCFromFile(ControllerConfiguration cc, String file) {
		RootELementGetter reg = new RootELementGetter();
		Element root = reg.getRoot(file);
		ExceptionThrower.throwConfigurationNotValidExcetion(root,file);
		if (root != null) {
			List<Element> interceptorList = root.elements(ConstantValues.INTERCEPTOR);
			HashMap<String, IInterceptor> interceptors = this.getInterceptors(interceptorList);
			cc.setInterceptorList(interceptors);
			List<Element> controllerList = root.elements(ConstantValues.PAGECONTROLLER);
			HashMap<String, PageControllerDescriptor> controllers = this.getPageControllers(controllerList);
			cc.setPageControllerList(controllers);
		}
	}

	/**
	 * @param eles
	 * @return xml文件中所有interceptor节点信息
	 */
	public HashMap<String, IInterceptor> getInterceptors(List<Element> eles) {

		HashMap<String, IInterceptor> interceptors = new HashMap<String, IInterceptor>();
		for (Element e : eles) {
			
			String name = e.attributeValue(ConstantValues.NAME);

			ExceptionThrower.throwEmptyExcetion(name, ConstantValues.INTERCEPTOR, ConstantValues.NAME);

			String className = e.attributeValue(ConstantValues.CLASS);

			ExceptionThrower.throwEmptyExcetion(className, ConstantValues.INTERCEPTOR, ConstantValues.CLASS);

			IInterceptor instance=null;
			try {
				instance = (IInterceptor) Class.forName(className).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			interceptors.put(name, instance);
		}
		return interceptors;
	}

	/**
	 * @param eles
	 * @return xml文件中所有页面控制器节点信息
	 */
	public HashMap<String, PageControllerDescriptor> getPageControllers(List<Element> eles) {

		HashMap<String, PageControllerDescriptor> pageControllers = new HashMap<String, PageControllerDescriptor>();
		for (Element e : eles) {
			PageControllerDescriptor pcd = new PageControllerDescriptor();
			String name = e.attributeValue(ConstantValues.NAME);
			String className = e.attributeValue(ConstantValues.CLASS);
			String methodName = e.attributeValue(ConstantValues.METHOD);

			List<Element> resultList = e.elements(ConstantValues.RESULT);
			HashMap<String, ResultDescriptor> results = this.getResults(resultList);

			List<Element> interceptorRefs = e.elements(ConstantValues.INTERCEPTORREF);
			List<String> interceptorList = this.getInterceptorRefs(interceptorRefs);

			ExceptionThrower.throwEmptyExcetion(name, ConstantValues.PAGECONTROLLER, ConstantValues.NAME);

			ExceptionThrower.throwEmptyExcetion(className, ConstantValues.PAGECONTROLLER, ConstantValues.CLASS);

			if (methodName == null || methodName.trim().equals("")) {
				methodName = ConstantValues.DEFAULTCONTROLLERMETHOD;
			}

			pcd.setName(name);
			pcd.setClassName(className);
			pcd.setMethodName(methodName);
			pcd.setResultsMap(results);
			pcd.setInterceptorsList(interceptorList);
			pageControllers.put(name, pcd);
		}
		return pageControllers;
	}

	/**
	 * @param eles
	 * @return 每个页面控制器节点中所有result节点信息
	 */
	public HashMap<String, ResultDescriptor> getResults(List<Element> eles) {
		HashMap<String, ResultDescriptor> results = new HashMap<String, ResultDescriptor>();
		for (Element e : eles) {
			ResultDescriptor rd = new ResultDescriptor();
			String name = e.attributeValue(ConstantValues.NAME);
			String type = e.attributeValue(ConstantValues.TYPE);
			String target = e.attributeValue(ConstantValues.TARGET);

			ExceptionThrower.throwEmptyExcetion(target, ConstantValues.RESULT, ConstantValues.TARGET);

			if (name == null || name.trim().equals("")) {
				name = ConstantValues.DEFAULTRESULTNAME;
			}
			if (type == null || type.trim().equals("")) {
				type = ConstantValues.DEFAULTRESULTTYPE;
			}

			rd.setResultName(name);
			rd.setResultType(type);
			rd.setResultTarget(target);
			results.put(name, rd);
		}
		return results;
	}

	/**
	 * @param eles
	 * @return 每个页面控制器的interceptor引用列表
	 */
	public List<String> getInterceptorRefs(List<Element> eles) {

		List<String> refs = new ArrayList<String>();
		for (Element e : eles) {
			String name = e.attributeValue(ConstantValues.NAME);

			ExceptionThrower.throwEmptyExcetion(name, ConstantValues.INTERCEPTORREF, ConstantValues.NAME);

			refs.add(name);
		}
		return refs;
	}

}
