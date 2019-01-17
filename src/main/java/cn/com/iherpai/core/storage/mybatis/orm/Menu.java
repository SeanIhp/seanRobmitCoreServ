package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Menu extends Entity implements Serializable {
	private static final long serialVersionUID = -8037574860884689941L;
	private Long		id;
	private Integer		nid;
	private String		sid;
	private String		name;
	private String		code;
	private String		url;
	private Integer		sortno;
	private Boolean		asParent;
	private Boolean		hasChild;
	private Integer		level;
	private	Long		parentId;
	private Integer		parentNid;
	private String		parentSid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSortno() {
		return sortno;
	}
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	public Boolean getAsParent() {
		return asParent;
	}
	public void setAsParent(Boolean asParent) {
		this.asParent = asParent;
	}
	public Boolean getHasChild() {
		return hasChild;
	}
	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getParentNid() {
		return parentNid;
	}
	public void setParentNid(Integer parentNid) {
		this.parentNid = parentNid;
	}
	public String getParentSid() {
		return parentSid;
	}
	public void setParentSid(String parentSid) {
		this.parentSid = parentSid;
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
