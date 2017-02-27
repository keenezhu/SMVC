package ustc.keene.mvc.tools;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class RootELementGetter {

	/**
	 * @return xml根节点元素
	 */
	public Element getRoot(String file) {
		File ccFile = new File(file);
		SAXReader reader = new SAXReader();
		Element ele = null;
		try {
			Document dom = reader.read(ccFile);
			ele = dom.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return ele;
	}
}