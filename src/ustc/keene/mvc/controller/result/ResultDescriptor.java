package ustc.keene.mvc.controller.result;

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
 *         用于封装结果逻辑值名，结果类型，资源位置等
 */
public class ResultDescriptor {
	
	private String resultName;
	private String resultType;
	private String resultTarget;

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultTarget() {
		return resultTarget;
	}

	public void setResultTarget(String resultTarget) {
		this.resultTarget = resultTarget;
	}

}
