package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Motion extends Entity implements Serializable {
	private static final long serialVersionUID = 130623122684324549L;
	
	private Long		id;
	private Integer		nid;
	private String		sid;
	private Long		meetingId;
	private Integer		meetingNid;
	private String		meetingSid;
	private Long		agendaId;
	private Integer		agendaNid;
	private String		agendaSid;
	private Long		accountId;
	private Integer		accountNid;
	private String		accountSid;
	private Integer		type;
	private Boolean		beSecond;
	private Boolean		beRediscuss;
	private Integer		discussCnt;
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
	public Long getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}
	public Integer getMeetingNid() {
		return meetingNid;
	}
	public void setMeetingNid(Integer meetingNid) {
		this.meetingNid = meetingNid;
	}
	public String getMeetingSid() {
		return meetingSid;
	}
	public void setMeetingSid(String meetingSid) {
		this.meetingSid = meetingSid;
	}
	public Long getAgendaId() {
		return agendaId;
	}
	public void setAgendaId(Long agendaId) {
		this.agendaId = agendaId;
	}
	public Integer getAgendaNid() {
		return agendaNid;
	}
	public void setAgendaNid(Integer agendaNid) {
		this.agendaNid = agendaNid;
	}
	public String getAgendaSid() {
		return agendaSid;
	}
	public void setAgendaSid(String agendaSid) {
		this.agendaSid = agendaSid;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Boolean getBeSecond() {
		return beSecond;
	}
	public void setBeSecond(Boolean beSecond) {
		this.beSecond = beSecond;
	}
	public Boolean getBeRediscuss() {
		return beRediscuss;
	}
	public void setBeRediscuss(Boolean beRediscuss) {
		this.beRediscuss = beRediscuss;
	}
	public Integer getDiscussCnt() {
		return discussCnt;
	}
	public void setDiscussCnt(Integer discussCnt) {
		this.discussCnt = discussCnt;
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
