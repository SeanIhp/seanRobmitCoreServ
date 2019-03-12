package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class DictGroup extends Orm implements Serializable {
	private static final long serialVersionUID = -638152134086808122L;

	public static final Integer		ROOT_NID 				= 1;
	public static final String		ROOT_SID 				= "10000000000000000000x1000000000000x100x1000000000000000000000x00";
	public static final String		ROOT_CODE 				= "ROOT";
	public static final String		ROOT_NAME 				= "ROOT";
	public static final Integer		ROOT_LEVEL 				= 0;
	public static final Integer		ROOT_STATUS 			= 1;
	
	

	public static final int 		STATUS_CREATED 			= 0;				//已创建，未使用
	public static final String 		STATUS_CREATED_TXT 		= "待使用";			//已创建，未使用
	
	public static final int 		STATUS_ENABLED 			= 1;				//正常，可使用
	public static final String 		STATUS_ENABLED_TXT 		= "可使用";			//正常，可使用
	
	public static final int 		STATUS_LOCKED_CHILD 	= -1;				//禁止添加任何子节点
	public static final String 		STATUS_LOCKED_CHILD_TXT = "子节点锁";			//禁止添加任何子节点
	
	public static final int 		STATUS_LOCKED_SUB 		= -2;				//禁止添加子字典组
	public static final String 		STATUS_LOCKED_SUB_TXT 	= "子组锁";			//禁止添加子字典组
	
	public static final int 		STATUS_LOCKED_LEAF 		= -3;				//禁止添加子字典
	public static final String 		STATUS_LOCKED_LEAF_TXT 	= "叶子锁";			//禁止添加子字典
	
	public static final int 		STATUS_DISABLED 		= -99;				//拒绝使用
	public static final String 		STATUS_DISABLED_TXT 	= "已禁用";			//拒绝使用
	
	public static final int 		LEVEL_MAX 				= 2;				//最大层级
	
	public static final String fieldsAll = "id, nid, sid, code, name, scode, sname, "
			+ "type, hasChild, level, sortno, parentId, parentNid, parentSid, "
			+ "description, createTime, status";
	
	public static final String fieldsDefault = "sid, code, name, scode, sname, "
			+ "type, hasChild, level, sortno, parentSid, "
			+ "description, createTime, status";

	private Long			id;
	private Integer			nid;
	private String			sid;
	private String			code;
	private String			name;
	private String 			scode;
	private String			sname;
	private Integer			type;
	private Boolean			hasChild;
	private Integer			level;
	private Integer			sortno;
	private Long			parentId;
	private Integer			parentNid;
	private String			parentSid;
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
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public Integer getSortno() {
		return sortno;
	}
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
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
