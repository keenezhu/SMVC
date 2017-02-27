package ustc.keene.mvc.viewer;

import ustc.keene.mvc.viewer.subviewer.ViewerAnchor;
import ustc.keene.mvc.viewer.subviewer.ViewerButton;
import ustc.keene.mvc.viewer.subviewer.ViewerFooter;
import ustc.keene.mvc.viewer.subviewer.ViewerForm;
import ustc.keene.mvc.viewer.subviewer.ViewerHeader;
import ustc.keene.mvc.viewer.subviewer.ViewerTextView;
import ustc.keene.mvc.viewer.subviewer.chrome.ChromeViewerAnchor;
import ustc.keene.mvc.viewer.subviewer.chrome.ChromeViewerButton;
import ustc.keene.mvc.viewer.subviewer.chrome.ChromeViewerFooter;
import ustc.keene.mvc.viewer.subviewer.chrome.ChromeViewerForm;
import ustc.keene.mvc.viewer.subviewer.chrome.ChromeViewerHeader;
import ustc.keene.mvc.viewer.subviewer.chrome.ChromeViewerTextView;

/**
 * @author keene C. zhu
 * 
 * 该代码遵循Apache License Version 2.0, January 2004。详细见http://www.apache.org/licenses/
 * 
 * Copyright {2015-2017} {keene C. zhu}
 * 
 * designed by keene, implemented by {coder name}
 * 
 * 负责创建面向Chrome浏览器的视图组件
 */
public class ChromeViewerComponentFactory extends ViewerComponentFatory {

	@Override
	public ViewerButton createButton(String name, String label) {
		ChromeViewerButton cvb = new ChromeViewerButton();
		return cvb;
	}

	@Override
	public ViewerTextView createTextView(String name, String value, int size, String label) {
		ChromeViewerTextView cvtv = new ChromeViewerTextView();
		return cvtv;
	}

	@Override
	public ViewerHeader createHeader(String title) {
		ChromeViewerHeader cvh = new ChromeViewerHeader();
		return cvh;
	}

	@Override
	public ViewerFooter createFooter(String title) {
		ChromeViewerFooter cvfoo = new ChromeViewerFooter();
		return cvfoo;
	}

	@Override
	public ViewerForm createForm(String name, String action) {
		ChromeViewerForm cvf = new ChromeViewerForm();
		return cvf;
	}

	@Override
	public ViewerAnchor createAnchor(String href, String label) {
		ChromeViewerAnchor cva = new ChromeViewerAnchor();
		return cva;
	}

}
