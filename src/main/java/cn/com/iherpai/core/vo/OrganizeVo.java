package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.Organize;

public class OrganizeVo extends Organize implements Serializable {
	private static final long serialVersionUID = -7790735130672917041L;
	
	public OrganizeVo() {
		super();
	}
	
	public OrganizeVo(Organize obj, ArrayList<String> fields) {
		if( fields.contains("id") ) {
			this.setId(obj.getId());
		}
		if( fields.contains("nid") ) {
			this.setNid(obj.getNid());
		}
		if( fields.contains("sid") ) {
			this.setSid(obj.getSid());
		}
		if( fields.contains("name") ) {
			this.setName(obj.getName());
		}
		if( fields.contains("code") ) {
			this.setCode(obj.getCode());
		}
		if( fields.contains("icon") ) {
			this.setIcon(obj.getIcon());
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

}
