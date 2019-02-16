package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;

public class DictGroupVo extends DictGroup implements Serializable {
	private static final long serialVersionUID = -8181070496651620541L;

	private Integer			levelMin;
	private Integer			levelMax;
	private Integer			statusMin;
	private Integer			statusMax;
	
	public DictGroupVo() {
		super();
	}
	
	public DictGroupVo(DictGroup dictGroup, ArrayList<String> fields) {
		if( fields.contains("id") ) {
			this.setId(dictGroup.getId());
		}
		if( fields.contains("nid") ) {
			this.setNid(dictGroup.getNid());
		}
		if( fields.contains("sid") ) {
			this.setSid(dictGroup.getSid());
		}
		if( fields.contains("code") ) {
			this.setCode(dictGroup.getCode());
		}
		if( fields.contains("name") ) {
			this.setName(dictGroup.getName());
		}
		if( fields.contains("scode") ) {
			this.setScode(dictGroup.getScode());
		}
		if( fields.contains("sname") ) {
			this.setSname(dictGroup.getSname());
		}
		if( fields.contains("type") ) {
			this.setType(dictGroup.getType());
		}
		if( fields.contains("hasChild") ) {
			this.setHasChild(dictGroup.getHasChild());
		}
		if( fields.contains("level") ) {
			this.setLevel(dictGroup.getLevel());
		}
		if( fields.contains("parentId") ) {
			this.setParentId(dictGroup.getParentId());
		}
		if( fields.contains("parentNid") ) {
			this.setParentNid(dictGroup.getParentNid());
		}
		if( fields.contains("parentSid") ) {
			this.setParentSid(dictGroup.getParentSid());
		}
		if( fields.contains("description") ) {
			this.setDescription(dictGroup.getDescription());
		}
		if( fields.contains("createTime") ) {
			this.setCreateTime(dictGroup.getCreateTime());
		}
		if( fields.contains("status") ) {
			this.setStatus(dictGroup.getStatus());
		}	
	}

	public Integer getLevelMin() {
		return levelMin;
	}

	public void setLevelMin(Integer levelMin) {
		this.levelMin = levelMin;
	}

	public Integer getLevelMax() {
		return levelMax;
	}

	public void setLevelMax(Integer levelMax) {
		this.levelMax = levelMax;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
