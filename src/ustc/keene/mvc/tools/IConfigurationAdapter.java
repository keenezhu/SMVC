package ustc.keene.mvc.tools;

import ustc.keene.mvc.controller.ControllerConfiguration;

/**
 * @author keene C. zhu
 * 
 * 该代码遵循Apache License Version 2.0, January 2004。详细见http://www.apache.org/licenses/
 * 
 * Copyright {2015-2017} {keene C. zhu}
 * 
 * designed by keene, implemented by {coder name}
 * 
 * 该接口负责将文件类型的配置文件转换成ControllerConfiguration对象类型
 * 
 */
public interface IConfigurationAdapter {
	
	public void getCCFromFile(ControllerConfiguration cc,String file);

}
