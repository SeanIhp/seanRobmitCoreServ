package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.MapTeamAccount;

public class MapTeamAccountVo extends MapTeamAccount implements Serializable {
	private static final long serialVersionUID = -8327193371636693125L;
	
	public MapTeamAccountVo() {
		super();
	}
	
	public MapTeamAccountVo(MapTeamAccount obj, ArrayList<String> fields) {
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
		if( fields.contains("teamId") ) {
			this.setTeamId(obj.getTeamId());
		}
		if( fields.contains("teamNid") ) {
			this.setTeamNid(obj.getTeamNid());
		}
		if( fields.contains("teamSid") ) {
			this.setTeamSid(obj.getTeamSid());
		}
		if( fields.contains("accountId") ) {
			this.setAccountId(obj.getAccountId());
		}
		if( fields.contains("accountNid") ) {
			this.setAccountNid(obj.getAccountNid());
		}
		if( fields.contains("accountSid") ) {
			this.setAccountSid(obj.getAccountSid());
		}
		if( fields.contains("nickname") ) {
			this.setNickname(obj.getNickname());
		}
		if( fields.contains("type") ) {
			this.setType(obj.getType());
		}
		if( fields.contains("grade") ) {
			this.setGrade(obj.getGrade());
		}
		if( fields.contains("score") ) {
			this.setScore(obj.getScore());
		}
		if( fields.contains("role") ) {
			this.setRole(obj.getRole());
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

}
