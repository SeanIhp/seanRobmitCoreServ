package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class MenuAuthentication extends Entity implements Serializable {
	private static final long serialVersionUID = 8221939409197193201L;
	
	private Long		id;
	private Integer		nid;
	private String		sid;
	private Long		menuId;
	private Integer		menuNid;
	private String		menuSid;
	private Integer		accountType;
	private Date		createTime;
	private Integer		status;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Integer getMenuNid() {
		return menuNid;
	}
	public void setMenuNid(Integer menuNid) {
		this.menuNid = menuNid;
	}
	public String getMenuSid() {
		return menuSid;
	}
	public void setMenuSid(String menuSid) {
		this.menuSid = menuSid;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}	
}
