package ustc.keene.mvc.viewer;

import java.util.List;

import ustc.keene.mvc.viewer.subviewer.ViewerFooter;
import ustc.keene.mvc.viewer.subviewer.ViewerForm;
import ustc.keene.mvc.viewer.subviewer.ViewerHeader;

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
 *         该类定义viewer基本结构
 */
public class Viewer {

	private String theme;
	private IViewerComponent header;
	private IViewerComponent footer;
	private List<IViewerComponent> body;

	public IViewerComponent getHeader() {
		return header;
	}

	public void setHeader(IViewerComponent header) {
		this.header = header;
	}

	public IViewerComponent getFooter() {
		return footer;
	}

	public void setFooter(IViewerComponent footer) {
		this.footer = footer;
	}

	public List<IViewerComponent> getBody() {
		return body;
	}

	public void setBody(List<IViewerComponent> body) {
		this.body = body;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

}
