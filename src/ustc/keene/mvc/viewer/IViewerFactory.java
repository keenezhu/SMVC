package ustc.keene.mvc.viewer;

/**
 * @author keene C. zhu
 * 
 * 该代码遵循Apache License Version 2.0, January 2004。详细见http://www.apache.org/licenses/
 * 
 * Copyright {2015-2017} {keene C. zhu}
 * 
 * designed by keene, implemented by {coder name}
 * 
 * 该接口定义负责生成Viewer对象的工厂方法
 */
public interface IViewerFactory {
	
	public Viewer getViewer();
	
}
