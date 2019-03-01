package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Orm implements Serializable {
	private static final long serialVersionUID = -7713402840423678550L;

	
	private String			pageKeys;
	private Integer			pageNo;
	private Integer			pageSize;
	private Integer 		pageTotal;
	private Long			pageAllTotal;
	private String			pageOrders;
	
	private ArrayList<HashMap>		maz = null;

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public ArrayList<HashMap> getMaz() {
		return maz;
	}

	public void setMaz(ArrayList<HashMap> maz) {
		this.maz = maz;
	}
	
	public void absMsk(int maxConditionLimit, boolean needAbsMsk) throws Exception {
		if(maxConditionLimit >= 0){
			if(this.maz.size()!=maxConditionLimit){
				throw new Exception("非法操作");
			}
		}
		if(needAbsMsk){
			for(int i=0; i<this.maz.size(); i++) {
				HashMap condition = (HashMap)this.maz.get(i);
				int msk = ((Integer)condition.get("msk")).intValue();
				condition.put( "msk", Math.abs(msk) );
			}
		}
	}
	
	public void addCondition(String key, String operater, String value, Integer msk) {
    	HashMap condition = new HashMap();
    	condition.put("key", key);
    	condition.put("op", operater);
    	condition.put("val", value);
    	condition.put("msk", msk);
		this.maz.add(condition);
	}
	
	public void addCondition(String key, String operater, Integer value, Integer msk) {
    	HashMap condition = new HashMap();
    	condition.put("key", key);
    	condition.put("op", operater);
    	condition.put("val", value);
    	condition.put("msk", msk);
		this.maz.add(condition);
	}
	
	public void addCondition(String key, String operater, Float value, Integer msk) {
    	HashMap condition = new HashMap();
    	condition.put("key", key);
    	condition.put("op", operater);
    	condition.put("val", value);
    	condition.put("msk", msk);
		this.maz.add(condition);
	}

}
