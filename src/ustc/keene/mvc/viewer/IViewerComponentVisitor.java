package ustc.keene.mvc.viewer;

import ustc.keene.mvc.viewer.subviewer.ViewerAnchor;
import ustc.keene.mvc.viewer.subviewer.ViewerButton;
import ustc.keene.mvc.viewer.subviewer.ViewerFooter;
import ustc.keene.mvc.viewer.subviewer.ViewerForm;
import ustc.keene.mvc.viewer.subviewer.ViewerHeader;
import ustc.keene.mvc.viewer.subviewer.ViewerTextView;

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
 *         负责访问不同Viewer组件生成特定Theme的Html代码
 */
public interface IViewerComponentVisitor {
	
	public void visit(ViewerButton vb);

	public void visit(ViewerTextView vtv);	
	
	public void visit(ViewerAnchor va);	

	public void visit(ViewerForm vf);

	public void visit(ViewerHeader vh);

	public void visit(ViewerFooter vfo);

	public String getViewerHtml();
	
}
