package cn.com.iherpai.core.storage.mybatis.exception;

public class DaoException extends Exception {
	private static final long serialVersionUID = -9026113074182099538L;
	
	public DaoException() {
		super("服务器维护中...");
	}
	
	public DaoException(String errorMsg) {
		super(errorMsg);
	}
	
	public DaoException(String[] args) {
		super("数据维护: [CASE: "+args[0]+"][DESC: "+args[1]+"]");
	}

}
