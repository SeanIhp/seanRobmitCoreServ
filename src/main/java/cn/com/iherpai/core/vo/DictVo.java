package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.Dict;

public class DictVo extends Dict implements Serializable {
	private static final long serialVersionUID = 3133381432288809078L;

	public DictVo() {
		super();
	}
	
	public DictVo(Dict ormDict, ArrayList<String> fields) {
		if( fields.contains("id") ) {
			this.setId(ormDict.getId());
		}
		if( fields.contains("nid") ) {
			this.setNid(ormDict.getNid());
		}
		if( fields.contains("sid") ) {
			this.setSid(ormDict.getSid());
		}
		if( fields.contains("dictGroupId") ) {
			this.setDictGroupId(ormDict.getDictGroupId());
		}
		if( fields.contains("dictGroupNid") ) {
			this.setDictGroupNid(ormDict.getDictGroupNid());
		}
		if( fields.contains("dictGroupSid") ) {
			this.setDictGroupSid(ormDict.getDictGroupSid());
		}
		if( fields.contains("code") ) {
			this.setCode(ormDict.getCode());
		}
		if( fields.contains("name") ) {
			this.setName(ormDict.getName());
		}
		if( fields.contains("constCode") ) {
			this.setConstCode(ormDict.getConstCode());
		}
		if( fields.contains("constType") ) {
			this.setConstType(ormDict.getConstType());
		}
		if( fields.contains("constValue") ) {
			this.setConstValue(ormDict.getConstValue());
		}
		if( fields.contains("constText") ) {
			this.setConstText(ormDict.getConstText());
		}
		if( fields.contains("sortno") ) {
			this.setSortno(ormDict.getSortno());
		}
		if( fields.contains("description") ) {
			this.setDescription(ormDict.getDescription());
		}
		if( fields.contains("createTime") ) {
			this.setCreateTime(ormDict.getCreateTime());
		}
		if( fields.contains("status") ) {
			this.setStatus(ormDict.getStatus());
		}	
	}
}
