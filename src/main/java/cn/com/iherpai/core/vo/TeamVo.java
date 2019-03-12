package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.Team;

public class TeamVo extends Team implements Serializable {
	private static final long serialVersionUID = -2064025462580976604L;
	
	private Long			account_id;
	private Integer			account_nid;
	private String			account_sid;

	public TeamVo() {
		super();
	}
	
	public TeamVo(Team obj, ArrayList<String> fields) {
		if( fields.contains("id") ) {
			this.setId(obj.getId());
		}
		if( fields.contains("nid") ) {
			this.setNid(obj.getNid());
		}
		if( fields.contains("sid") ) {
			this.setSid(obj.getSid());
		}
		if( fields.contains("organizeId") ) {
			this.setOrganizeId(obj.getOrganizeId());
		}
		if( fields.contains("organizeNid") ) {
			this.setOrganizeNid(obj.getOrganizeNid());
		}
		if( fields.contains("organizeSid") ) {
			this.setOrganizeSid(obj.getOrganizeSid());
		}
		if( fields.contains("name") ) {
			this.setName(obj.getName());
		}
		if( fields.contains("code") ) {
			this.setCode(obj.getCode());
		}
		if( fields.contains("type") ) {
			this.setType(obj.getType());
		}
		if( fields.contains("icon") ) {
			this.setIcon(obj.getIcon());
		}
		if( fields.contains("intro") ) {
			this.setIntro(obj.getIntro());
		}
		if( fields.contains("grade") ) {
			this.setGrade(obj.getGrade());
		}
		if( fields.contains("gradeTitle") ) {
			this.setGradeTitle(obj.getGradeTitle());
		}
		if( fields.contains("total") ) {
			this.setTotal(obj.getTotal());
		}
		if( fields.contains("settingMessage") ) {
			this.setSettingMessage(obj.getSettingMessage());
		}
		if( fields.contains("settingTop") ) {
			this.setSettingTop(obj.getSettingTop());
		}
		if( fields.contains("settingJoin") ) {
			this.setSettingJoin(obj.getSettingJoin());
		}
		if( fields.contains("settingVisit") ) {
			this.setSettingVisit(obj.getSettingVisit());
		}
		if( fields.contains("settingSpeak") ) {
			this.setSettingSpeak(obj.getSettingSpeak());
		}
		if( fields.contains("settingAlias") ) {
			this.setSettingAlias(obj.getSettingAlias());
		}
		if( fields.contains("level") ) {
			this.setLevel(obj.getLevel());
		}
		if( fields.contains("createTime") ) {
			this.setCreateTime(obj.getCreateTime());
		}
		if( fields.contains("status") ) {
			this.setStatus(obj.getStatus());
		}	
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public Integer getAccount_nid() {
		return account_nid;
	}

	public void setAccount_nid(Integer account_nid) {
		this.account_nid = account_nid;
	}

	public String getAccount_sid() {
		return account_sid;
	}

	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}
}
