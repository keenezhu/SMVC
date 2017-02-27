package ustc.keene.mvc.viewer;

import java.util.List;

import ustc.keene.mvc.viewer.subviewer.ViewerForm;

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
 *         负责使用ViewerComponentVisitor对象将Viewer对象生成对应的html代码
 */
public class HTMLGenerator {
	/**
	 * @param v
	 * @param vcv
	 * @return Viewer的html标签字符串
	 */
	public static String generateHtml(Viewer v, IViewerComponentVisitor vcv) {

		v.getHeader().accept(vcv);
		List<IViewerComponent> body = v.getBody();
		for (IViewerComponent vc : body) {
			vc.accept(vcv);
		}
		v.getFooter().accept(vcv);
		
		return vcv.getViewerHtml();
		
	}
}
