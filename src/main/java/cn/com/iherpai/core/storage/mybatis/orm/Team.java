package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Team extends Orm implements Serializable {
	private static final long serialVersionUID = -6492554219503830L;

	public static final int 		STATUS_CREATED 			= 0;				//已创建，未使用
	public static final String 		STATUS_CREATED_TXT 		= "待使用";			//已创建，未使用
	
	public static final int 		STATUS_ENABLED 			= 1;				//正常，可使用
	public static final String 		STATUS_ENABLED_TXT 		= "可使用";			//正常，可使用
	
	public static final int 		STATUS_DISABLED 		= -99;				//拒绝使用
	public static final String 		STATUS_DISABLED_TXT 	= "已禁用";			//拒绝使用
	
	public static final String fieldsAll = "id, nid, sid, organize_id, organize_nid, organize_sid, "
			+ "name, code, type, icon, intro, grade, gradeTitle, total, "
			+ "settingMessage, settingTop, settingJoin, settingVisit, settingSpeak, settingAlias, "
			+ "level, createTime, status";
	
	public static final String fieldsDefault = "sid, organize_sid, "
			+ "name, code, type, icon, intro, grade, gradeTitle, total, "
			+ "settingMessage, settingTop, settingJoin, settingVisit, settingSpeak, settingAlias, "
			+ "level, createTime, status";
	
	private Long			id;
	private Integer			nid;
	private String			sid;
	private Long			organizeId;
	private Integer			organizeNid;
	private String			organizeSid;
	private	String			name;
	private String			code;
	private Integer			type;
	private String			icon;
	private String			intro;
	private Integer			grade;
	private String			gradeTitle;
	private Integer			total;
	private Integer			settingMessage;
	private Boolean			settingTop;
	private Integer			settingJoin;
	private Integer			settingVisit;
	private Integer			settingSpeak;
	private Integer			settingAlias;
	private Integer			level;
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

	public Long getOrganizeId() {
		return organizeId;
	}

	public void setOrganizeId(Long organizeId) {
		this.organizeId = organizeId;
	}

	public Integer getOrganizeNid() {
		return organizeNid;
	}

	public void setOrganizeNid(Integer organizeNid) {
		this.organizeNid = organizeNid;
	}

	public String getOrganizeSid() {
		return organizeSid;
	}

	public void setOrganizeSid(String organizeSid) {
		this.organizeSid = organizeSid;
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

	public Integer getSettingAlias() {
		return settingAlias;
	}

	public void setSettingAlias(Integer settingAlias) {
		this.settingAlias = settingAlias;
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
