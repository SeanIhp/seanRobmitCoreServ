package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Organize extends Orm implements Serializable {
	private static final long serialVersionUID = -4113474425569807163L;
	
	public static final int 		CHILDCOUNT_MAX 			= 10;				//拒绝使用
	
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
	
	public static final String fieldsAll = "id, nid, sid, parent_id, parent_nid, parent_sid, is_valid, child_count, "
			+ "name, code, type, icon, intro, grade, gradeTitle, total, "
			+ "settingMessage, settingTop, settingJoin, settingVisit, settingSpeak, "
			+ "level, createTime, status";
	
	public static final String fieldsDefault = "sid, parent_sid, is_valid, child_count, "
			+ "name, code, type, icon, intro, grade, gradeTitle, total, "
			+ "settingMessage, settingTop, settingJoin, settingVisit, settingSpeak, "
			+ "level, createTime, status";
	
	private Long		id;
	private Integer		nid;
	private String		sid;
	private Long		parentId;
	private Integer		parentNid;
	private String		parentSid;
	private Boolean		isValid;
	private Integer		childCount;
	private String		name;
	private String		code;
	private Integer		type;
	private String		icon;
	private String		intro;
	private Integer		grade;
	private String		gradeTitle;
	private Integer		total;
	private Integer		settingMessage;
	private Boolean		settingTop;
	private Integer		settingJoin;
	private Integer		settingVisit;
	private Integer		settingSpeak;
	private Integer		level;
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

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Integer getChildCount() {
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getGradeTitle() {
		return gradeTitle;
	}

	public void setGradeTitle(String gradeTitle) {
		this.gradeTitle = gradeTitle;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getSettingMessage() {
		return settingMessage;
	}

	public void setSettingMessage(Integer settingMessage) {
		this.settingMessage = settingMessage;
	}

	public Boolean getSettingTop() {
		return settingTop;
	}

	public void setSettingTop(Boolean settingTop) {
		this.settingTop = settingTop;
	}

	public Integer getSettingJoin() {
		return settingJoin;
	}

	public void setSettingJoin(Integer settingJoin) {
		this.settingJoin = settingJoin;
	}

	public Integer getSettingVisit() {
		return settingVisit;
	}

	public void setSettingVisit(Integer settingVisit) {
		this.settingVisit = settingVisit;
	}

	public Integer getSettingSpeak() {
		return settingSpeak;
	}

	public void setSettingSpeak(Integer settingSpeak) {
		this.settingSpeak = settingSpeak;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
