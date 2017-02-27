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
 *         定义视图TextView组件
 */
public abstract class ViewerTextView implements IViewerComponent {
	protected String name, value, label;
	protected int size;

	@Override
	public void accept(IViewerComponentVisitor vcv) {
		vcv.visit(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
