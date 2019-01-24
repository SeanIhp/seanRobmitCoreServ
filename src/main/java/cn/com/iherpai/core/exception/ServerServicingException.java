package cn.com.iherpai.core.exception;

public class ServerServicingException extends Exception {
	private static final long serialVersionUID = -2604561437883161878L;
	
	public ServerServicingException() {
		super("服务器维护中，请稍后重试！");
	}
	
	public ServerServicingException(String msg) {
		super(msg);
	}
	
	public ServerServicingException(String[] args) {
		super("服务器维护中，请稍后重试！");
	}
}
