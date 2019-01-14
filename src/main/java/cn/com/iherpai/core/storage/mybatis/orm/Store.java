package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {
	private static final long serialVersionUID = -602934776952939772L;
	public static String DEFAULT_ALL_FIELDS = "id, sid, serialId, "
			+ "mid, merchant_id, aid, account_id, "
			+ "cid, category_id, name, code, intro, "
			+ "wx_latitude, wx_longitude, createTime, status";
	
	private Long			id;
	private String			sid;
	private String			serialId;
	private Long			mid;
	private String			merchant_id;
	private Long			aid;
	private String			account_id;
	private Long			cid;
	private String			category_id;
	private String			name;
	private String			code;
	private String			intro;
	private String			wx_latitude;
	private String			wx_longitude;
	private Date			createTime;
	private Integer			status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getWx_latitude() {
		return wx_latitude;
	}
	public void setWx_latitude(String wx_latitude) {
		this.wx_latitude = wx_latitude;
	}
	public String getWx_longitude() {
		return wx_longitude;
	}
	public void setWx_longitude(String wx_longitude) {
		this.wx_longitude = wx_longitude;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
