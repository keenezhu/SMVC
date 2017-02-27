package ustc.keene.mvc.test.login;

import ustc.keene.mvc.controller.IPageController;
import ustc.keene.mvc.controller.PageControllerContext;

public class LoginPageController implements IPageController {

	@Override
	public String handle(PageControllerContext context) {

		return "failure";
	}

	public String login() {
		
		return "failure";
	}

}
