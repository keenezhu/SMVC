package ustc.keene.mvc.tools;

public class ExceptionThrower {

	public static void throwEmptyExcetion(String value, String subjectName, String attrName) {
		if (value == null || value.trim().equals("")) {
			Exception ex = new Exception(subjectName + "的属性:" + attrName + "未定义!");
			try {
				throw ex;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void throwConfigurationNotFoundExcetion() {

		Exception e = new Exception("未找到xml或json类型的配置文件!");
		try {
			throw e;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void throwConfigurationNotValidExcetion(Object o, String file) {
		if (o == null) {
			Exception e = new Exception(file + "不是一个有效的配置文件!");
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void throwPageControllerNotFoundException(Object o) {
		if (o == null) {
			Exception e = new Exception("未找到指定名称的PageController!");
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void throwInterceptorNotFoundException(Object o) {
		if (o == null) {
			Exception e = new Exception("未找到指定名称的Interceptor!");
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void throwResultNotFoundException(Object o) {
		if (o == null) {
			Exception e = new Exception("未找到指定名称的Result!");
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void throwResultCannotBeHandled() {
		Exception e = new Exception("请求的资源类型无法被正确处理!");
		try {
			throw e;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
