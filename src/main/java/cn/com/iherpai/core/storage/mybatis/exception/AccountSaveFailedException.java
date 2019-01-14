package cn.com.iherpai.core.storage.mybatis.exception;

/*
 * 帐户注册数据写入失败
 */
public class AccountSaveFailedException extends Exception {
	private static final long serialVersionUID = -7445611398938841346L;
	
	public AccountSaveFailedException() {
		super("帐户资料保存失败");
	}
	
	public AccountSaveFailedException(String[] args) {
		super("帐户资料[ID:"+args[0]+"][NAME:"+args[1]+"]保存失败");
	}
}
