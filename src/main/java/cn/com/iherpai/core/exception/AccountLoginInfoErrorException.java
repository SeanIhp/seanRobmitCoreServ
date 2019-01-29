package cn.com.iherpai.core.exception;

public class AccountLoginInfoErrorException extends Exception {
	private static final long serialVersionUID = -5900763587944932419L;
	
	public AccountLoginInfoErrorException() {
		super("用户名/密码错误");
	}
	
	public AccountLoginInfoErrorException(String msg) {
		super(msg);
	}
	
	public AccountLoginInfoErrorException(String[] args) {
		super("用户名/密码错误");
	}
}
