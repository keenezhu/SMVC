package ustc.keene.mvc.controller;

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
 *         该接口是web
 *         app请求处理的页面控制器，实现每个request请求业务处理逻辑实现，业务逻辑处理方法为handle（），返回业务处理结果字符串
 */
public interface IPageController {

	/**
	 * 业务逻辑处理方法
	 * 
	 * 不输入任何参数，从请求上下文中取出业务逻辑处理所需的request值
	 * 
	 * 返回字符串结果，用于请求结果分发
	 * 
	 * @return result string
	 */
	public String handle(PageControllerContext context);

}
