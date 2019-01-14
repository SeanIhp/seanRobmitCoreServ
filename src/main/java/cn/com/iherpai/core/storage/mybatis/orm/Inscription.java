package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.sql.Date;

public class Inscription extends Entity implements Serializable {
	private static final long serialVersionUID = -4418438010618735199L;
	
	private Long			id;						//
	private String			serialId;				//
	private Long			account_id;
	private Float			wx_latitude;
	private Float			wx_longitude;
	private Integer			type;
	private String			content;
	private String			resource;
	private Date			createTime;
	private Long			score;
	private Integer			favor;
	private Integer			praise;
	private Integer			despise;
	private Integer			status;					//状态

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public Float getWx_latitude() {
		return wx_latitude;
	}

	public void setWx_latitude(Float wx_latitude) {
		this.wx_latitude = wx_latitude;
	}

	public Float getWx_longitude() {
		return wx_longitude;
	}

	public void setWx_longitude(Float wx_longitude) {
		this.wx_longitude = wx_longitude;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	public Integer getDespise() {
		return despise;
	}

	public void setDespise(Integer despise) {
		this.despise = despise;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
