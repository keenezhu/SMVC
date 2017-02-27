package ustc.keene.mvc.controller.result;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ustc.keene.mvc.tools.ConstantValues;

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
 *         该类为结果处理责任链上一个节点类，负责处理请求结果为html资源时结果的分发
 */
public class HtmlResourceHandler extends ResultHandler {

	@Override
	public boolean handled(ResultDescriptor rd, HttpServletRequest req, HttpServletResponse resp) {
		String resultTarget = rd.getResultTarget();
		if (resultTarget.endsWith("html")) {
			String hostName = req.getServletContext().getContextPath();
			String hostPath = req.getRequestURL().toString();
			String realPath = hostPath.substring(0, hostPath.indexOf(hostName)) + hostName + "/";
			try {
				if (rd.getResultType().equals(ConstantValues.DEFAULTRESULTTYPE)) {
					req.getServletContext().getRequestDispatcher("/" + resultTarget).forward(req, resp);
				} else {
					resp.sendRedirect(realPath + resultTarget);
				}
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

}
