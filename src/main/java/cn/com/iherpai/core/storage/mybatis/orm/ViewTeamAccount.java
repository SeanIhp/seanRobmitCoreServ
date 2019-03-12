package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class ViewTeamAccount extends Orm implements Serializable {
	private static final long serialVersionUID = -8105110830770128079L;
	
	public static final String fieldsAll = "id, nid, sid, organizeId, organizeNid, organizeSid, "
			+ "teamId, teamNid, teamSid, accountId, accountNid, accountSid, "
			+ "mapNickname, mapType, mapGrade, mapScore, mapRole, mapCreateTime, mapStatus"
			+ "accoUsername, accoType, accoGrade, accoPhone, accoScore, accoLevel, accoStatus"
			+ "teamName, teamCode, teamType, teamGrade, teamTotal, teamLevel, teamStatus";
	
	public static final String fieldsDefault = "sid, organizeSid, teamSid, accountSid, "
			+ "mapNickname, mapType, mapGrade, mapScore, mapRole, mapCreateTime, mapStatus"
			+ "accoUsername, accoType, accoGrade, accoPhone, accoScore, accoLevel, accoStatus"
			+ "teamName, teamCode, teamType, teamGrade, teamTotal, teamLevel, teamStatus";

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
	private String		mapNickname;
	private Integer		mapType;
	private Integer		mapGrade;
	private Long		mapScore;
	private Integer		mapRole;
	private Date		mapCreateTime;
	private Integer		mapStatus;
	private String		accoUsername;				
	private Integer		accoType; 
	private Integer		accoGrade;
	private String		accoPhone;					
	private Long		accoScore;					
	private Integer		accoLevel;					
	private Integer		accoStatus;				
	private	String		teamName;
	private String		teamCode;
	private Integer		teamType;
	private Integer		teamGrade;
	private Integer		teamTotal;
	private Integer		teamLevel;
	private Integer		teamStatus;
	
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
	public String getMapNickname() {
		return mapNickname;
	}
	public void setMapNickname(String mapNickname) {
		this.mapNickname = mapNickname;
	}
	public Integer getMapType() {
		return mapType;
	}
	public void setMapType(Integer mapType) {
		this.mapType = mapType;
	}
	public Integer getMapGrade() {
		return mapGrade;
	}
	public void setMapGrade(Integer mapGrade) {
		this.mapGrade = mapGrade;
	}
	public Long getMapScore() {
		return mapScore;
	}
	public void setMapScore(Long mapScore) {
		this.mapScore = mapScore;
	}
	public Integer getMapRole() {
		return mapRole;
	}
	public void setMapRole(Integer mapRole) {
		this.mapRole = mapRole;
	}
	public Date getMapCreateTime() {
		return mapCreateTime;
	}
	public void setMapCreateTime(Date mapCreateTime) {
		this.mapCreateTime = mapCreateTime;
	}
	public Integer getMapStatus() {
		return mapStatus;
	}
	public void setMapStatus(Integer mapStatus) {
		this.mapStatus = mapStatus;
	}
	public String getAccoUsername() {
		return accoUsername;
	}
	public void setAccoUsername(String accoUsername) {
		this.accoUsername = accoUsername;
	}
	public Integer getAccoType() {
		return accoType;
	}
	public void setAccoType(Integer accoType) {
		this.accoType = accoType;
	}
	public Integer getAccoGrade() {
		return accoGrade;
	}
	public void setAccoGrade(Integer accoGrade) {
		this.accoGrade = accoGrade;
	}
	public String getAccoPhone() {
		return accoPhone;
	}
	public void setAccoPhone(String accoPhone) {
		this.accoPhone = accoPhone;
	}
	public Long getAccoScore() {
		return accoScore;
	}
	public void setAccoScore(Long accoScore) {
		this.accoScore = accoScore;
	}
	public Integer getAccoLevel() {
		return accoLevel;
	}
	public void setAccoLevel(Integer accoLevel) {
		this.accoLevel = accoLevel;
	}
	public Integer getAccoStatus() {
		return accoStatus;
	}
	public void setAccoStatus(Integer accoStatus) {
		this.accoStatus = accoStatus;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public Integer getTeamType() {
		return teamType;
	}
	public void setTeamType(Integer teamType) {
		this.teamType = teamType;
	}
	public Integer getTeamGrade() {
		return teamGrade;
	}
	public void setTeamGrade(Integer teamGrade) {
		this.teamGrade = teamGrade;
	}
	public Integer getTeamTotal() {
		return teamTotal;
	}
	public void setTeamTotal(Integer teamTotal) {
		this.teamTotal = teamTotal;
	}
	public Integer getTeamLevel() {
		return teamLevel;
	}
	public void setTeamLevel(Integer teamLevel) {
		this.teamLevel = teamLevel;
	}
	public Integer getTeamStatus() {
		return teamStatus;
	}
	public void setTeamStatus(Integer teamStatus) {
		this.teamStatus = teamStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
