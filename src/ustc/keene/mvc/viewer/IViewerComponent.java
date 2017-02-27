package ustc.keene.mvc.viewer;

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
 *         负责定义每个ViewerComponent对象的accept行为和getHtml行为，为了构建Visitor模式&生成每个视图Html代码
 */
public interface IViewerComponent {

	public void accept(IViewerComponentVisitor vcv);

	public String getHtml();

}
