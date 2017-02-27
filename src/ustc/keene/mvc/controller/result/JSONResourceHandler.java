package ustc.keene.mvc.controller.result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSONResourceHandler extends ResultHandler {

	@Override
	public boolean handled(ResultDescriptor rd, HttpServletRequest req, HttpServletResponse resp) {
	
		return false;
	}

}
