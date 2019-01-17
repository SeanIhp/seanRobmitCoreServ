package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Category extends Entity implements Serializable {
	private static final long serialVersionUID = -602934776952939772L;	
	
	private Long			id;
	private Integer			nid;
	private String			sid;
	private String			name;
	private String			code;
	private String			icon;
	private String			intro;
	private String			level;
	private Boolean			asRoot;
	private Boolean			hasChild;
	private String			sequenceNumber;
	private Long			rootId;
	private Integer			rootNid;
	private String			rootSid;
	private Long			parentId;
	private Integer			parentNid;
	private String			parentSid;
	private Date			createTime;
	private Integer			status;

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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Boolean getAsRoot() {
		return asRoot;
	}
	public void setAsRoot(Boolean asRoot) {
		this.asRoot = asRoot;
	}
	public Boolean getHasChild() {
		return hasChild;
	}
	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public Long getRootId() {
		return rootId;
	}
	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}
	public Integer getRootNid() {
		return rootNid;
	}
	public void setRootNid(Integer rootNid) {
		this.rootNid = rootNid;
	}
	public String getRootSid() {
		return rootSid;
	}
	public void setRootSid(String rootSid) {
		this.rootSid = rootSid;
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
