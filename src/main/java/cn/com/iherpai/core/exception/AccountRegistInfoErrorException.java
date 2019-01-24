package cn.com.iherpai.core.exception;

/*
 * 注册时用户名、密码等数据不符合规则
 */
public class AccountRegistInfoErrorException extends Exception {
	private static final long serialVersionUID = -5502652075129069389L;
	
	public AccountRegistInfoErrorException() {
		super("用户名/密码不符合填写规则");
	}
	
	public AccountRegistInfoErrorException(String msg) {
		super(msg);
	}
	
	public AccountRegistInfoErrorException(String[] args) {
		super("用户名/密码不符合填写规则");
	}
}
