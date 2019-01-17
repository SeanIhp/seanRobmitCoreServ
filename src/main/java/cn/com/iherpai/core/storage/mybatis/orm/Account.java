package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

import cn.com.iherpai.common.underware.DataValidator;

import java.sql.Timestamp;

public class Account extends Entity implements Serializable {
	private static final long serialVersionUID = -7450117829974407869L;
	public static final Integer 	STATUS_DEFAULT = 1;					//正常
	public static final Integer 	STATUS_LOCK = 2;					//交互锁
	public static final Integer 	STATUS_DENY = 3;					//拒绝服务
	public static final String 		HOST_SITE_ID_DEFAULT = "11";		//Iherpai.com.cn
	
	private Long			id;						//
	private Integer			nid;				//
	private String			sid;				//
	private String			username;				//
	private String			password;				//
	private String			question;
	private String			answer;
	private String			mailbox;
	private String			wx_openid;				//
	private String			wx_sessionkey;			//
	private String			wx_unionid;				//
	private String			wx_nickname;			//
	private String			wx_avatar;				//
	private Integer			wx_gender;				//
	private String			wx_city;				//
	private String			wx_country;				//
	private String			wx_province;			//
	private String			wx_language;			//
	private Integer			type; 
	private Integer			grade;
	private String			phone;					//电话号码
	private Long			score;					//积分
	private Integer			level;					//等级
	private Date			createTime;
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
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getWx_openid() {
		return wx_openid;
	}
	public void setWx_openid(String wx_openid) {
		this.wx_openid = wx_openid;
	}
	public String getWx_sessionkey() {
		return wx_sessionkey;
	}
	public void setWx_sessionkey(String wx_sessionkey) {
		this.wx_sessionkey = wx_sessionkey;
	}
	public String getWx_unionid() {
		return wx_unionid;
	}
	public void setWx_unionid(String wx_unionid) {
		this.wx_unionid = wx_unionid;
	}
	public String getWx_nickname() {
		return wx_nickname;
	}
	public void setWx_nickname(String wx_nickname) {
		this.wx_nickname = wx_nickname;
	}
	public String getWx_avatar() {
		return wx_avatar;
	}
	public void setWx_avatar(String wx_avatar) {
		this.wx_avatar = wx_avatar;
	}
	public Integer getWx_gender() {
		return wx_gender;
	}
	public void setWx_gender(Integer wx_gender) {
		this.wx_gender = wx_gender;
	}
	public String getWx_city() {
		return wx_city;
	}
	public void setWx_city(String wx_city) {
		this.wx_city = wx_city;
	}
	public String getWx_country() {
		return wx_country;
	}
	public void setWx_country(String wx_country) {
		this.wx_country = wx_country;
	}
	public String getWx_province() {
		return wx_province;
	}
	public void setWx_province(String wx_province) {
		this.wx_province = wx_province;
	}
	public String getWx_language() {
		return wx_language;
	}
	public void setWx_language(String wx_language) {
		this.wx_language = wx_language;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
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
