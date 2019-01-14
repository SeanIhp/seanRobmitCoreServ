package cn.com.iherpai.core.storage.mybatis.exception;

import java.lang.Exception;

/*
 * 创建了过多的小组
 */
public class CreateGroupTooManyException extends Exception {
	private static final long serialVersionUID = 1402298110015009240L;

	public CreateGroupTooManyException() {
		super("已达到单个ID可创建小组的数量限制");
	}
	
	public CreateGroupTooManyException(String[] args) {
		super("已达到创建小组的数量限制，单个ID最多允许创建"+args[0]+"个小组");
	}
}
