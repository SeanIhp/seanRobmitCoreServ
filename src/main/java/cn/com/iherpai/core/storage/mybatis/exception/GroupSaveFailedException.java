package cn.com.iherpai.core.storage.mybatis.exception;

/*
 * 帐户注册数据写入失败
 */
public class GroupSaveFailedException extends Exception {
	private static final long serialVersionUID = 2049367754712378114L;

	public GroupSaveFailedException() {
		super("小组资料保存失败");
	}
	
	public GroupSaveFailedException(String[] args) {
		super("小组资料[ID:"+args[0]+"][NAME:"+args[1]+"]保存失败");
	}
}
