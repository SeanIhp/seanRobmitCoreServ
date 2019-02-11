package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.Agenda;

public class AgendaVo extends Agenda implements Serializable {
	private static final long serialVersionUID = 4389519107146753531L;
	
	private Integer			statusMin;
	private Integer			statusMax;
	
	public AgendaVo() {
		super();
	}
	
	public AgendaVo(Agenda ormAgenda, ArrayList<String> fields) {
		if( fields.contains("id") ) {
			this.setId(ormAgenda.getId());
		}
		if( fields.contains("nid") ) {
			this.setNid(ormAgenda.getNid());
		}
		if( fields.contains("sid") ) {
			this.setSid(ormAgenda.getSid());
		}
		if( fields.contains("meetingId") ) {
			this.setId(ormAgenda.getMeetingId());
		}
		if( fields.contains("meetingNid") ) {
			this.setMeetingNid(ormAgenda.getMeetingNid());
		}
		if( fields.contains("meetingSid") ) {
			this.setMeetingSid(ormAgenda.getMeetingSid());
		}
		if( fields.contains("sortno") ) {
			this.setSortno(ormAgenda.getSortno());
		}
		if( fields.contains("content") ) {
			this.setContent(ormAgenda.getContent());
		}
		if( fields.contains("durationExpect") ) {
			this.setDurationExpect(ormAgenda.getDurationExpect());
		}
		if( fields.contains("duration") ) {
			this.setDuration(ormAgenda.getDuration());
		}
		if( fields.contains("accountId") ) {
			this.setAccountId(ormAgenda.getAccountId());
		}
		if( fields.contains("accountNid") ) {
			this.setAccountNid(ormAgenda.getAccountNid());
		}
		if( fields.contains("accountSid") ) {
			this.setAccountSid(ormAgenda.getAccountSid());
		}
		if( fields.contains("createTime") ) {
			this.setCreateTime(ormAgenda.getCreateTime());
		}
		if( fields.contains("status") ) {
			this.setStatus(ormAgenda.getStatus());
		}
		
	}
	
	public Integer getStatusMin() {
		return statusMin;
	}
	public void setStatusMin(Integer statusMin) {
		this.statusMin = statusMin;
	}
	public Integer getStatusMax() {
		return statusMax;
	}
	public void setStatusMax(Integer statusMax) {
		this.statusMax = statusMax;
	}

}
