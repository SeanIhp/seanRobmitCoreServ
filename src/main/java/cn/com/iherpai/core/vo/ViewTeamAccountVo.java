package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.ViewTeamAccount;

public class ViewTeamAccountVo extends ViewTeamAccount implements Serializable {
	private static final long serialVersionUID = 7863583486803131483L;
	
	public ViewTeamAccountVo(){
		super();
	}
	
	public ViewTeamAccountVo(ViewTeamAccount obj, ArrayList<String> fields){
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
		if( fields.contains("mapNickname") ) {
			this.setMapNickname(obj.getMapNickname());
		}
		if( fields.contains("mapType") ) {
			this.setMapType(obj.getMapType());
		}
		if( fields.contains("mapGrade") ) {
			this.setMapGrade(obj.getMapGrade());
		}
		if( fields.contains("mapScore") ) {
			this.setMapScore(obj.getMapScore());
		}
		if( fields.contains("mapRole") ) {
			this.setMapRole(obj.getMapRole());
		}
		if( fields.contains("mapCreateTime") ) {
			this.setMapCreateTime(obj.getMapCreateTime());
		}
		if( fields.contains("mapStatus") ) {
			this.setMapStatus(obj.getMapStatus());
		}
		if( fields.contains("accoUsername") ) {
			this.setAccoUsername(obj.getAccoUsername());
		}
		if( fields.contains("accoType") ) {
			this.setAccoType(obj.getAccoType());
		}
		if( fields.contains("accoGrade") ) {
			this.setAccoGrade(obj.getAccoGrade());
		}
		if( fields.contains("accoPhone") ) {
			this.setAccoPhone(obj.getAccoPhone());
		}	
		if( fields.contains("accoScore") ) {
			this.setAccoScore(obj.getAccoScore());
		}
		if( fields.contains("accoLevel") ) {
			this.setAccoLevel(obj.getAccoLevel());
		}
		if( fields.contains("accoStatus") ) {
			this.setAccoStatus(obj.getAccoStatus());
		}
		if( fields.contains("teamName") ) {
			this.setTeamName(obj.getTeamName());
		}
		if( fields.contains("teamCode") ) {
			this.setTeamCode(obj.getTeamCode());
		}
		if( fields.contains("teamType") ) {
			this.setTeamType(obj.getTeamType());
		}
		if( fields.contains("teamGrade") ) {
			this.setTeamGrade(obj.getTeamGrade());
		}
		if( fields.contains("teamTotal") ) {
			this.setTeamTotal(obj.getTeamTotal());
		}
		if( fields.contains("teamLevel") ) {
			this.setTeamLevel(obj.getTeamLevel());
		}
		if( fields.contains("teamStatus") ) {
			this.setTeamStatus(obj.getTeamStatus());
		}
	}
}
