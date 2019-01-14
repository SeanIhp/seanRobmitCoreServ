package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
	private static final long serialVersionUID = -602934776952939772L;
	public static String DEFAULT_ALL_FIELDS = "id, cid, serialId, "
			+ "name, code, icon, intro, level, asRoot, hasChild, "
			+ "sequenceNumber, rootId, rootCid, parentId, parentCid, "
			+ "createTime, status";
	
	private Long			id;
	private String			cid;
	private String			serialId;
	private String			name;
	private String			code;
	private String			icon;
	private String			intro;
	private String			level;
	private Boolean			asRoot;
	private Boolean			hasChild;
	private String			sequenceNumber;
	private Long			rootId;
	private String			rootCid;
	private Long			parentId;
	private String			parentCid;
	private Date			createTime;
	private Integer			status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
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
	public String getRootCid() {
		return rootCid;
	}
	public void setRootCid(String rootCid) {
		this.rootCid = rootCid;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentCid() {
		return parentCid;
	}
	public void setParentCid(String parentCid) {
		this.parentCid = parentCid;
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
