package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Meeting extends Entity implements Serializable {
	private static final long serialVersionUID = -8748727491625001718L;
	private Long		id;
	private Integer		nid;
	private String		sid;
	private String		title;
	private String		subTitle;
	private Integer		level;
	private Integer		levelAlpha;
	private Integer		levelBeta;
	private Integer		levelCharlie;
	private Date		joinTime;
	private Date		startTime;
	private Date		endTime;
	private Integer		minJoin;
	private Integer		invitedCount;
	private Integer		joinedCount;
	private Boolean		isHost;
	private Boolean		isVote;
	private Boolean		isDelineation;
	private Boolean		isInvite;
	private Boolean		canAgent;
	private Long		accountId;
	private Integer		accountNid;
	private String		accountSid;
	private Long		hostAccountId;
	private Integer		hostAccountNid;
	private String		hostAccountSid;
	private Long		secretaryAccountId;
	private Integer		secretaryAccountNid;
	private String		secretaryAccountSid;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getLevelAlpha() {
		return levelAlpha;
	}
	public void setLevelAlpha(Integer levelAlpha) {
		this.levelAlpha = levelAlpha;
	}
	public Integer getLevelBeta() {
		return levelBeta;
	}
	public void setLevelBeta(Integer levelBeta) {
		this.levelBeta = levelBeta;
	}
	public Integer getLevelCharlie() {
		return levelCharlie;
	}
	public void setLevelCharlie(Integer levelCharlie) {
		this.levelCharlie = levelCharlie;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getMinJoin() {
		return minJoin;
	}
	public void setMinJoin(Integer minJoin) {
		this.minJoin = minJoin;
	}
	public Integer getInvitedCount() {
		return invitedCount;
	}
	public void setInvitedCount(Integer invitedCount) {
		this.invitedCount = invitedCount;
	}
	public Integer getJoinedCount() {
		return joinedCount;
	}
	public void setJoinedCount(Integer joinedCount) {
		this.joinedCount = joinedCount;
	}
	public Boolean getIsHost() {
		return isHost;
	}
	public void setIsHost(Boolean isHost) {
		this.isHost = isHost;
	}
	public Boolean getIsVote() {
		return isVote;
	}
	public void setIsVote(Boolean isVote) {
		this.isVote = isVote;
	}
	public Boolean getIsDelineation() {
		return isDelineation;
	}
	public void setIsDelineation(Boolean isDelineation) {
		this.isDelineation = isDelineation;
	}
	public Boolean getIsInvite() {
		return isInvite;
	}
	public void setIsInvite(Boolean isInvite) {
		this.isInvite = isInvite;
	}
	public Boolean getCanAgent() {
		return canAgent;
	}
	public void setCanAgent(Boolean canAgent) {
		this.canAgent = canAgent;
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
	public Long getHostAccountId() {
		return hostAccountId;
	}
	public void setHostAccountId(Long hostAccountId) {
		this.hostAccountId = hostAccountId;
	}
	public Integer getHostAccountNid() {
		return hostAccountNid;
	}
	public void setHostAccountNid(Integer hostAccountNid) {
		this.hostAccountNid = hostAccountNid;
	}
	public String getHostAccountSid() {
		return hostAccountSid;
	}
	public void setHostAccountSid(String hostAccountSid) {
		this.hostAccountSid = hostAccountSid;
	}
	public Long getSecretaryAccountId() {
		return secretaryAccountId;
	}
	public void setSecretaryAccountId(Long secretaryAccountId) {
		this.secretaryAccountId = secretaryAccountId;
	}
	public Integer getSecretaryAccountNid() {
		return secretaryAccountNid;
	}
	public void setSecretaryAccountNid(Integer secretaryAccountNid) {
		this.secretaryAccountNid = secretaryAccountNid;
	}
	public String getSecretaryAccountSid() {
		return secretaryAccountSid;
	}
	public void setSecretaryAccountSid(String secretaryAccountSid) {
		this.secretaryAccountSid = secretaryAccountSid;
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
