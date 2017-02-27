package ustc.keene.mvc.controller;

import java.io.File;
import java.util.HashMap;

import ustc.keene.mvc.controller.interceptor.IInterceptor;
import ustc.keene.mvc.tools.ExceptionThrower;
import ustc.keene.mvc.tools.IConfigurationAdapter;
import ustc.keene.mvc.tools.JSONConfigurationParser;
import ustc.keene.mvc.tools.XMLConfigurationParser;

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
 *         该类用于放置页面控制器配置文件解析后的结果，可以用于查找页面控制器逻辑名及对应的PageControllerDescriptor对象，
 *         定义的拦截器对象InterceptorDescriptor等
 */
public class ControllerConfiguration {

	private static String configurationFile;

	private HashMap<String, PageControllerDescriptor> pageControllerList;
	private HashMap<String, IInterceptor> interceptorList;

	private static ControllerConfiguration cc = null;

	private ControllerConfiguration() {
		initConfigurationFile();
	}

	/**
	 * 初始化configurationFile变量，判断在classes/目录下是否有合法的配置文件
	 * 如无，将configurationFile赋值为“”
	 */
	private void initConfigurationFile() {

		String path = ControllerConfiguration.class.getResource("/").getPath();
		configurationFile = path + "controller.xml";
		File f = new File(configurationFile);
		if (!f.exists()) {
			configurationFile = path + "controller.json";
			f = new File(configurationFile);
			if (!f.exists()) {
				configurationFile = "";
			}
		}
	}

	private static ControllerConfiguration buildCC() {

		synchronized (ControllerConfiguration.class) {
			if (cc == null) {
				cc = new ControllerConfiguration();
				IConfigurationAdapter ica = null;
				if (configurationFile.endsWith(".xml")) {
					ica = new XMLConfigurationParser();
				} else if (configurationFile.endsWith(".json")) {
					ica = new JSONConfigurationParser();
				} else {
					ExceptionThrower.throwConfigurationNotFoundExcetion();
				}
				ica.getCCFromFile(cc, configurationFile);
			}
		}

		return cc;
	}

	public static ControllerConfiguration getInstance() {
		if (cc == null) {
			cc = buildCC();
		}
		return cc;
	}

	public PageControllerDescriptor findController(String key) {
		return pageControllerList.get(key);
	}

	public IInterceptor findInterceptor(String key) {
		return interceptorList.get(key);
	}

	public HashMap<String, PageControllerDescriptor> getPageControllerList() {
		return pageControllerList;
	}

	public void setPageControllerList(HashMap<String, PageControllerDescriptor> pageControllerList) {
		this.pageControllerList = pageControllerList;
	}

	public HashMap<String, IInterceptor> getInterceptorList() {
		return interceptorList;
	}

	public void setInterceptorList(HashMap<String, IInterceptor> interceptorList) {
		this.interceptorList = interceptorList;
	}
}
