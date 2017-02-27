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
 *         负责构造ViewerComponent具体子类对象
 */
public abstract class ViewerComponentFatory {

	public abstract ViewerButton createButton(String name, String label);

	public abstract ViewerAnchor createAnchor(String href, String label);

	public abstract ViewerTextView createTextView(String name, String value, int size, String label);

	public abstract ViewerHeader createHeader(String title);

	public abstract ViewerFooter createFooter(String title);

	public abstract ViewerForm createForm(String name, String action);

}
