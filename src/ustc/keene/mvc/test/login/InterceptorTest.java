package ustc.keene.mvc.test.login;

import ustc.keene.mvc.controller.PageControllerContext;
import ustc.keene.mvc.controller.interceptor.IInterceptor;

public class InterceptorTest implements IInterceptor {

	@Override
	public String preDo(PageControllerContext pcc) {
		System.out.println("predo");
		return null;
	}

	@Override
	public String afterDo(PageControllerContext pcc) {
		System.out.println("afterdo");
		return null;
	}

}
