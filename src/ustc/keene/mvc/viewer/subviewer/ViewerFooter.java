package ustc.keene.mvc.viewer.subviewer;

import ustc.keene.mvc.viewer.IViewerComponent;
import ustc.keene.mvc.viewer.IViewerComponentVisitor;

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
 *         定义视图Footer组件
 */
public abstract class ViewerFooter implements IViewerComponent {
	protected String title;

	@Override
	public void accept(IViewerComponentVisitor vcv) {
		vcv.visit(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
