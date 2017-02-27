package ustc.keene.mvc.test;

import java.util.HashMap;

import ustc.keene.mvc.controller.ControllerConfiguration;
import ustc.keene.mvc.controller.PageControllerDescriptor;
import ustc.keene.mvc.controller.interceptor.IInterceptor;

/**
 * @author keene zhu
 * 
 *         该代码遵循Apache License Version 2.0, January
 *         2004。详细见http://www.apache.org/licenses/
 * 
 *         Copyright {2015-2017} {keene zhu}
 * 
 *         designed by keene, implemented by {coder name}
 */
public class MainEntrance {

	public static void main(String[] args) {
		ControllerConfiguration cc = ControllerConfiguration.getInstance();
		HashMap<String, IInterceptor> interceptorList = cc.getInterceptorList();
		HashMap<String, PageControllerDescriptor> pageControllerList = cc.getPageControllerList();

		interceptorList.forEach((key, val) -> System.out.println(key + ":::" + val.toString()));
		pageControllerList.forEach((key, val) -> System.out.println(
				key + ":::" + val.getClassName() + ":::" + val.getMethodName() + ":::" + val.getInterceptorsList()));

		pageControllerList.forEach((key, val) -> val.getResultsMap().forEach((rkey, rval) -> System.out
				.println(rkey + ":::" + rval.getResultType() + ":::" + rval.getResultTarget())));

	}

}