package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.Category;

public class CategoryVo extends Category implements Serializable {
	private static final long serialVersionUID = -1871303298996330292L;
	
	private Integer			levelMin;
	private Integer			levelMax;
	private Integer			statusMin;
	private Integer			statusMax;
	
	public CategoryVo() {
		super();
	}
	
	public CategoryVo(Category ormCategory, ArrayList<String> fields) {
		if( fields.contains("id") ) {
			this.setId(ormCategory.getId());
		}
		if( fields.contains("nid") ) {
			this.setNid(ormCategory.getNid());
		}
		if( fields.contains("sid") ) {
			this.setSid(ormCategory.getSid());
		}
		if( fields.contains("name") ) {
			this.setName(ormCategory.getName());
		}
		if( fields.contains("code") ) {
			this.setCode(ormCategory.getCode());
		}
		if( fields.contains("icon") ) {
			this.setIcon(ormCategory.getIcon());
		}
		if( fields.contains("intro") ) {
			this.setIntro(ormCategory.getIntro());
		}
		if( fields.contains("level") ) {
			this.setLevel(ormCategory.getLevel());
		}
		if( fields.contains("asRoot") ) {
			this.setAsRoot(ormCategory.getAsRoot());
		}
		if( fields.contains("hasChild") ) {
			this.setHasChild(ormCategory.getHasChild());
		}
		if( fields.contains("sequenceNumber") ) {
			this.setSequenceNumber(ormCategory.getSequenceNumber());
		}
		if( fields.contains("rootId") ) {
			this.setRootId(ormCategory.getRootId());
		}
		if( fields.contains("rootNid") ) {
			this.setRootNid(ormCategory.getRootNid());
		}
		if( fields.contains("rootSid") ) {
			this.setRootSid(ormCategory.getRootSid());
		}
		if( fields.contains("parentId") ) {
			this.setParentId(ormCategory.getParentId());
		}
		if( fields.contains("parentNid") ) {
			this.setParentNid(ormCategory.getParentNid());
		}
		if( fields.contains("parentSid") ) {
			this.setParentSid(ormCategory.getParentSid());
		}
		if( fields.contains("createTime") ) {
			this.setCreateTime(ormCategory.getCreateTime());
		}
		if( fields.contains("status") ) {
			this.setStatus(ormCategory.getStatus());
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
