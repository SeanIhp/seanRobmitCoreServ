package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Dict extends Orm implements Serializable {
	private static final long serialVersionUID = -602934776952939772L;

	public static final int 		STATUS_CREATED 			= 0;				//已创建，未使用
	public static final String 		STATUS_CREATED_TXT 		= "待使用";			//已创建，未使用
	
	public static final int 		STATUS_ENABLED 			= 1;				//正常，可使用
	public static final String 		STATUS_ENABLED_TXT 		= "可使用";			//正常，可使用
	
	public static final int 		STATUS_DISABLED 		= -99;				//拒绝使用
	public static final String 		STATUS_DISABLED_TXT 	= "已禁用";			//拒绝使用
	
	public static final String fieldsAll = "id, nid, sid, dictGroupId, dictGroupNid, dictGroupSid, "
			+ "code, name, constCode, constType, constValue, constText, sortno, "
			+ "description, createTime, status";
	
	public static final String fieldsDefault = "sid, dictGroupSid, code, name, "
			+ "sortno, description, createTime, status";
	
	private Long			id;
	private Integer			nid;
	private String			sid;
	private	Long			dictGroupId;
	private Integer			dictGroupNid;
	private String			dictGroupSid;
	private String			code;
	private String			name;
	private String			constCode;
	private String			constType;
	private String			constValue;
	private String			constText;
	private Integer			sortno;
	private String			description;
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
	public Long getDictGroupId() {
		return dictGroupId;
	}
	public void setDictGroupId(Long dictGroupId) {
		this.dictGroupId = dictGroupId;
	}
	public Integer getDictGroupNid() {
		return dictGroupNid;
	}
	public void setDictGroupNid(Integer dictGroupNid) {
		this.dictGroupNid = dictGroupNid;
	}
	public String getDictGroupSid() {
		return dictGroupSid;
	}
	public void setDictGroupSid(String dictGroupSid) {
		this.dictGroupSid = dictGroupSid;
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
	public Integer getSortno() {
		return sortno;
	}
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
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
