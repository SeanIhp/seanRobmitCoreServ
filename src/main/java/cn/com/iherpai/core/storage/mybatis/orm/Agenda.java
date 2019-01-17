package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Agenda extends Entity implements Serializable {
	private static final long serialVersionUID = 7702482223662656397L;
	
	private Long		id;
	private Integer		nid;
	private String		sid;
	private Long		meetingId;
	private Integer		meetingNid;
	private String		meetingSid;
	private Integer		sortno;
	private	String		content;
	private Integer		durationExpect;
	private Integer		duration;
	private Long		accountId;
	private Integer		accountNid;
	private String		accountSid;
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

	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getDurationExpect() {
		return durationExpect;
	}

	public void setDurationExpect(Integer durationExpect) {
		this.durationExpect = durationExpect;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
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
