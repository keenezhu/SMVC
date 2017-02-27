/**
 * 
 */
package ustc.keene.mvc.controller.interceptor;

import ustc.keene.mvc.controller.PageControllerContext;

/**
 * @author keene C. zhu
 * 
 * 该代码遵循Apache License Version 2.0, January 2004。详细见http://www.apache.org/licenses/
 * 
 * Copyright {2015-2017} {keene zhu}
 * 
 * designed by keene, implemented by {coder name}
 */
public interface IInterceptor {
 
	/**
	 * 该方法用于子类拦截器实现请求拦截功能，在PageController处理请求之前调用
	 * 返回String类型结果
	 * @return String
	 */
	public String preDo(PageControllerContext pcc);
	/**
	 * 该方法用于子类拦截器实现请求拦截功能，在PageController处理请求之后调用
	 * 返回String类型结果
	 * @return String
	 */
	public String afterDo(PageControllerContext pcc);
}
