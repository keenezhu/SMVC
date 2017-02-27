package ustc.keene.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 *         该类是页面控制器PageController上下文，里面存储当前web请求提交数据及页面控制器处理业务逻辑需要的其他数据
 * 
 *         每个web请求生成一个新的PageControllerContext对象，并在构造该对象时传入HttpServletRequest，
 *         HttpServletResponse参数
 */
public class PageControllerContext {

	/**
	 * fieldsValue域用于存储浏览器提交的数据域值，采用映射<key,Object>方式存储 key为域名称，Object为该域的值对象
	 */
	private Map<String, Object> fieldsValue;

	/**
	 * response引用当前web请求的HttpServletResponse对象
	 */
	private HttpServletResponse response;

	/**
	 * request引用当前web请求的HttpServletRequest对象
	 */
	private HttpServletRequest request;

	public PageControllerContext(HttpServletRequest req, HttpServletResponse resp) {
		request = req;
		response = resp;
	}

	/**
	 * 获取指定key的数据域值对象，传入key参数，返回该key的值对象
	 * 
	 * @param key
	 * @return key对应的值对象
	 */
	public Object getFieldValue(String key) {
        if (fieldsValue!=null){
        	return fieldsValue.get(key);
        }
		return null;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

}
