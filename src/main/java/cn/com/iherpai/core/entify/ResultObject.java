package cn.com.iherpai.core.entify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultObject {
	
	private int returnCode = 0;
	private Map<String, Object> data = new HashMap<String, Object>(0);
	
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public void addData(String dataKey, Object data) {
		this.data.put(dataKey, data);
	}
	
}
