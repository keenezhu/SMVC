package ustc.keene.mvc.controller.result;

public class ChainOfResultHandlerFactory {
	private static ResultHandler rh;

	private static synchronized void buildChainOfResultHandler() {
		if (rh == null) {
			rh = new HtmlResourceHandler();
			rh.nextHandler = new JSONResourceHandler();
			rh.nextHandler.nextHandler = new XMLResourceHandler();
		}
	}

	public static ResultHandler getResultHandlerChain() {
		if (rh == null) {
			buildChainOfResultHandler();
		}
		return rh;
	}
}
