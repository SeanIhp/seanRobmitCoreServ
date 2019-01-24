package cn.com.iherpai.core.exception;

public class DaoException extends Exception {
	private static final long serialVersionUID = -9026113074182099538L;
	
	public DaoException() {
		super("数据访问失败，请稍后重试！");
	}
	
	public DaoException(String msg) {
		super(msg);
	}
	
	public DaoException(String[] args) {
		super(args[0]);
	}
}
