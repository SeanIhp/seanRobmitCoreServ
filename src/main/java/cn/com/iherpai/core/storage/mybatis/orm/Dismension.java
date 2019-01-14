package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.sql.Date;

public class Dismension extends Entity implements Serializable {
	private static final long serialVersionUID = -7220792689633672638L;
	
	private Long			id;						//
	private String			serialId;				//
	private Long			account_id;				//
	private String			name;					//
	private String			code;					//
	private String			password;				//
	private Long			memberCount;
	private Long			inscriptionCount;
	private String			intro;
	private Date			createTime;
	private Integer			status;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Long memberCount) {
		this.memberCount = memberCount;
	}
	public Long getInscriptionCount() {
		return inscriptionCount;
	}
	public void setInscriptionCount(Long inscriptionCount) {
		this.inscriptionCount = inscriptionCount;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
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
