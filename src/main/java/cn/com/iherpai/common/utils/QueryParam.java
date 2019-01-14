package cn.com.iherpai.common.utils;

public class QueryParam {
	private String	 			fields;
	private String				order_field;
	private String				order_direc;
	private Integer				page_no;
	private Integer				page_size;
	private String[]			params;
	
	public class ConditionParam{
		private String mode;
		private	String kay;
		private String value;
		
		public ConditionParam() {}

		public String getMode() {
			return mode;
		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public String getKay() {
			return kay;
		}

		public void setKay(String kay) {
			this.kay = kay;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}		
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getOrder_field() {
		return order_field;
	}

	public void setOrder_field(String order_field) {
		this.order_field = order_field;
	}

	public String getOrder_direc() {
		return order_direc;
	}

	public void setOrder_direc(String order_direc) {
		this.order_direc = order_direc;
	}

	public Integer getPage_no() {
		return page_no;
	}

	public void setPage_no(Integer page_no) {
		this.page_no = page_no;
	}

	public Integer getPage_size() {
		return page_size;
	}

	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	} 
	
}

/*
"	\"params\": [ "+
"				\"N,EX,X,N:code:user_status\", " +		
"				\"Q,FN,Q,Z:name:aaa,bbb,ccc\", "+
"				\"Q,EX,Q,Z:name:aaa,bbb,ccc\", "+
"				\"H,KO,Q,Y:description:abc\" "+
"				] "+
"}";
*/

/*
* N: 无缀逻辑运算符		Q：前缀AND		H：前缀OR	F: 前缀NOT
* EX: ==				NE: <>			DE: >=		XE: <=		KO: LIKE 'key*'		OK: LIKE '*key'		K: LIKE '*key*'		MT: IN (key)		EN: IS NULL		FN：IS NOT NULL	
* N: 无前缀后缀括号		Z: 前缀左括号		Y: 后缀右括号	 
*/





