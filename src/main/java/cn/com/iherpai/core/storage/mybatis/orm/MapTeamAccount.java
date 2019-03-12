package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class MapTeamAccount extends Entity implements Serializable {
	private static final long serialVersionUID = -3585588225496650439L;

	public static final int 		STATUS_CREATED 			= 0;				//已创建，未使用
	public static final String 		STATUS_CREATED_TXT 		= "待使用";			//已创建，未使用
	
	public static final int 		STATUS_ENABLED 			= 1;				//正常，可使用
	public static final String 		STATUS_ENABLED_TXT 		= "可使用";			//正常，可使用
	
	public static final int 		STATUS_DISABLED 		= -99;				//拒绝使用
	public static final String 		STATUS_DISABLED_TXT 	= "已禁用";			//拒绝使用
	
	public static final String fieldsAll = "id, nid, sid, organizeId, organizeNid, organizeSid, "
			+ "teamId, teamNid, teamSid, accountId, accountNid, accountSid, "
			+ "nickname, type, grade, score, role, createTime, status";
	
	public static final String fieldsDefault = "sid, organizeSid, teamSid, accountSid, "
			+ "nickname, type, grade, score, role, createTime, status";
	
	private Long		id;
	private Integer		nid;
	private String		sid;
	private Long		organizeId;
	private Integer		organizeNid;
	private String		organizeSid;
	private Long		teamId;
	private Integer		teamNid;
	private String		teamSid;
	private Long		accountId;
	private Integer		accountNid;
	private String		accountSid;
	private String		nickname;
	private Integer		type;
	private Integer		grade;
	private Long		score;
	private Integer		role;
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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Integer getTeamNid() {
		return teamNid;
	}

	public void setTeamNid(Integer teamNid) {
		this.teamNid = teamNid;
	}

	public String getTeamSid() {
		return teamSid;
	}

	public void setTeamSid(String teamSid) {
		this.teamSid = teamSid;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getAccountNid() {
		return accountNid;
	}

	public void setAccountNid(Integer accountNid) {
		this.accountNid = accountNid;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
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
