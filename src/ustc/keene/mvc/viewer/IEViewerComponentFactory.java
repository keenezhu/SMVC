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
 * 该代码遵循Apache License Version 2.0, January 2004。详细见http://www.apache.org/licenses/
 * 
 * Copyright {2015-2017} {keene C. zhu}
 * 
 * designed by keene, implemented by {coder name}
 * 
 * 负责创建面向IE浏览器的视图组件
 */
public class IEViewerComponentFactory extends ViewerComponentFatory {

	@Override
	public ViewerButton createButton(String name, String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewerTextView createTextView(String name, String value, int size, String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewerHeader createHeader(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewerFooter createFooter(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewerForm createForm(String name, String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewerAnchor createAnchor(String href, String label) {
		// TODO Auto-generated method stub
		return null;
	}

}
