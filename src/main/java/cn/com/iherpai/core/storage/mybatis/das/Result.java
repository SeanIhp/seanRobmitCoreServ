package cn.com.iherpai.core.storage.mybatis.das;

public class Result {
	private String errMsg = null;
	private Object resObj = null;
	private boolean end = false; 
	
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Object getResObj() {
		return resObj;
	}
	public void setResObj(Object resObj) {
		this.resObj = resObj;
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
}
