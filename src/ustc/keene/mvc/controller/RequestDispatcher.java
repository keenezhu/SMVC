package ustc.keene.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ustc.keene.mvc.controller.result.ResultDispatcher;
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
 *         该类负责Request分发
 */
public class RequestDispatcher {

	/**
	 * 传入HttpServlet请求参数HttpServletRequest和HttpServletResponse
	 * 
	 * @param req
	 * @param resp
	 */
	public static void dispatch(HttpServletRequest req, HttpServletResponse resp) {
		String requestURI = req.getRequestURI();
		if (requestURI.endsWith(".sc")) {
			int startIndex = requestURI.lastIndexOf("/");
			int endIndex = requestURI.lastIndexOf(".sc");
			String controllerName = requestURI.substring(startIndex + 1, endIndex);
			PageControllerDescriptor pcd = ControllerConfiguration.getInstance().findController(controllerName);
			ExceptionThrower.throwPageControllerNotFoundException(pcd);
			IPageController ipc = new PageControllerProxy(pcd);
			String result = ipc.handle(initPageControllerContext(req));
			ResultDispatcher.dispatch(result, pcd, req, resp);
		}
	}

	private static PageControllerContext initPageControllerContext(HttpServletRequest req) {
		return null;
	}

}
