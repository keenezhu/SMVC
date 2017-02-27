package ustc.keene.mvc.controller;

import java.util.HashMap;
import java.util.List;

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
 *         该类用于封装页面控制器描述信息，包括控制器逻辑名，对应的页面控制器类名，调用方法，
 *         配置的拦截器对象及对应的ResultDescriptor对象等
 */
public class PageControllerDescriptor {

	private String name;
	private String className;
	private String methodName = "handle";
	private List<String> interceptorsList;
	private HashMap<String, ResultDescriptor> resultsMap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public List<String> getInterceptorsList() {
		return interceptorsList;
	}

	public void setInterceptorsList(List<String> interceptorsList) {
		this.interceptorsList = interceptorsList;
	}

	public HashMap<String, ResultDescriptor> getResultsMap() {
		return resultsMap;
	}

	public void setResultsMap(HashMap<String, ResultDescriptor> resultsMap) {
		this.resultsMap = resultsMap;
	}

}
