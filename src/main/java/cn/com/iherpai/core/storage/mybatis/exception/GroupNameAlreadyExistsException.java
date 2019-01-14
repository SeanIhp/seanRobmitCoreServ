package cn.com.iherpai.core.storage.mybatis.exception;

import java.lang.Exception;

/*
 * 小组名称已被占用
 */
public class GroupNameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = -9083410439131916629L;

	public GroupNameAlreadyExistsException() {
		super("小组名称已被占用");
	}
	
	public GroupNameAlreadyExistsException(String[] args) {
		super("小组名称"+args[0]+"已被占用");
	}
}
