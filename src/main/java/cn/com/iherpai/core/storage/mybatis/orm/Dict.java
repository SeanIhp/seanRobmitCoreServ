package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Dict implements Serializable {
	private static final long serialVersionUID = -602934776952939772L;
	public static String DEFAULT_ALL_FIELDS = "id, did, serialId, "
			+ "dictGroup_id, dictGroup_dgid, "
			+ "name, code, constCode, constType, "
			+ "constValue, constText, sortNo, level, "
			+ "description, createTime, status";
	
	private Long			id;
	private String			did;
	private String			serialId;
	private	Long			dictGroup_id;
	private String			dictGroup_dgid;
	private String			name;
	private String			code;
	private String			constCode;
	private String			constType;
	private String			constValue;
	private String			constText;
	private String			sortNo;
	private String			description;
	private Date			createTime;
	private Integer			status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public Long getDictGroup_id() {
		return dictGroup_id;
	}
	public void setDictGroup_id(Long dictGroup_id) {
		this.dictGroup_id = dictGroup_id;
	}
	public String getDictGroup_dgid() {
		return dictGroup_dgid;
	}
	public void setDictGroup_dgid(String dictGroup_dgid) {
		this.dictGroup_dgid = dictGroup_dgid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConstCode() {
		return constCode;
	}
	public void setConstCode(String constCode) {
		this.constCode = constCode;
	}
	public String getConstType() {
		return constType;
	}
	public void setConstType(String constType) {
		this.constType = constType;
	}
	public String getConstValue() {
		return constValue;
	}
	public void setConstValue(String constValue) {
		this.constValue = constValue;
	}
	public String getConstText() {
		return constText;
	}
	public void setConstText(String constText) {
		this.constText = constText;
	}
	public String getSortNo() {
		return sortNo;
	}
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
