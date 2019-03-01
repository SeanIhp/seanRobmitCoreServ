package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;

import cn.com.iherpai.core.storage.mybatis.orm.Dict;

public class DictVo extends Dict implements Serializable {
	private static final long serialVersionUID = 3133381432288809078L;
	
	private Dict selfObj = new Dict();

	private Integer			sortnoMin;
	private Integer			sortnoMax;
	private Integer			statusMin;
	private Integer			statusMax;
	private String			sids;
	private String			pageKeys;
	private Integer			pageNo;
	private Integer			pageSize;
	private Integer 		pageTotal;
	private Long			pageAllTotal;
	private String			pageOrders;

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

	public Dict getSelfObj() {
		return selfObj;
	}

	public void setSelfObj(Dict selfObj) {
		this.selfObj = selfObj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getSortnoMin() {
		return sortnoMin;
	}

	public void setSortnoMin(Integer sortnoMin) {
		this.sortnoMin = sortnoMin;
	}

	public Integer getSortnoMax() {
		return sortnoMax;
	}

	public void setSortnoMax(Integer sortnoMax) {
		this.sortnoMax = sortnoMax;
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

	public String getSids() {
		return sids;
	}

	public void setSids(String sids) {
		this.sids = sids;
	}

	public String getPageKeys() {
		return pageKeys;
	}

	public void setPageKeys(String pageKeys) {
		this.pageKeys = pageKeys;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Long getPageAllTotal() {
		return pageAllTotal;
	}

	public void setPageAllTotal(Long pageAllTotal) {
		this.pageAllTotal = pageAllTotal;
	}

	public String getPageOrders() {
		return pageOrders;
	}

	public void setPageOrders(String pageOrders) {
		this.pageOrders = pageOrders;
	}
}
