package cn.com.iherpai.core.exception;

import java.lang.Exception;

/*
 * 用户名已被占用
 */
public class AccountNameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 5756238013243875347L;
	
	public AccountNameAlreadyExistsException() {
		super("用户名已被占用");
	}
	
	public AccountNameAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public AccountNameAlreadyExistsException(String[] args) {
		super("用户名"+args[0]+"已被占用");
	}
}
