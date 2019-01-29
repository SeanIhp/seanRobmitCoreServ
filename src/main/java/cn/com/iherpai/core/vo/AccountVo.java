package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import cn.com.iherpai.core.storage.mybatis.orm.Account;

public class AccountVo extends Account implements Serializable {
	private static final long serialVersionUID = 3094336313759441343L;
	
//	private Long			id;						//
//	private Integer			nid;				//
//	private String			sid;				//
//	private String			username;				//
//	private String			password;				//
	private String			newPassword;				//
//	private String			question;
//	private String			answer;
//	private String			mailbox;
//	private String			wxOpenid;				//
//	private String			wxSessionkey;			//
//	private String			wxUnionid;				//
//	private String			wxNickname;			//
//	private String			wxAvatar;				//
//	private Integer			wxGender;				//
//	private String			wxCity;				//
//	private String			wxCountry;				//
//	private String			wxProvince;			//
//	private String			wxLanguage;			//
//	private Integer			type; 
//	private Integer			grade;
//	private String			phone;					//电话号码
//	private Long			score;					//积分
//	private Integer			level;					//等级
//	private Date			createTime;
//	private Integer			status;					//状态

	public AccountVo() {
		super();
	}
	
	public AccountVo(Account ormAccount, ArrayList<String> fields) {
		if( fields.contains("id") ) {
			this.setId(ormAccount.getId());
		}
		if( fields.contains("nid") ) {
			this.setNid(ormAccount.getNid());
		}
		if( fields.contains("sid") ) {
			this.setSid(ormAccount.getSid());
		}
		if( fields.contains("username") ) {
			this.setUsername(ormAccount.getUsername());
		}
		if( fields.contains("password") ) {
			this.setPassword(ormAccount.getPassword());
		}
		if( fields.contains("question") ) {
			this.setQuestion(ormAccount.getQuestion());
		}
		if( fields.contains("answer") ) {
			this.setAnswer(ormAccount.getAnswer());
		}
		if( fields.contains("mailbox") ) {
			this.setMailbox(ormAccount.getMailbox());
		}
		if( fields.contains("wxOpenid") ) {
			this.setWxOpenid(ormAccount.getWxOpenid());
		}
		if( fields.contains("wxSessionkey") ) {
			this.setWxSessionkey(ormAccount.getWxSessionkey());
		}
		if( fields.contains("wxUnionid") ) {
			this.setWxUnionid(ormAccount.getWxUnionid());
		}
		if( fields.contains("wxNickname") ) {
			this.setWxNickname(ormAccount.getWxNickname());
		}
		if( fields.contains("wxAvatar") ) {
			this.setWxAvatar(ormAccount.getWxAvatar());
		}
		if( fields.contains("wxGender") ) {
			this.setWxGender(ormAccount.getWxGender());
		}
		if( fields.contains("wxCity") ) {
			this.setWxCity(ormAccount.getWxCity());
		}
		if( fields.contains("wxCountry") ) {
			this.setWxCountry(ormAccount.getWxCountry());
		}
		if( fields.contains("wxProvince") ) {
			this.setWxProvince(ormAccount.getWxProvince());
		}
		if( fields.contains("wxLanguage") ) {
			this.setWxLanguage(ormAccount.getWxLanguage());
		}
		if( fields.contains("type") ) {
			this.setType(ormAccount.getType());
		}
		if( fields.contains("grade") ) {
			this.setGrade(ormAccount.getGrade());
		}
		if( fields.contains("phone") ) {
			this.setPhone(ormAccount.getPhone());
		}
		if( fields.contains("score") ) {
			this.setScore(ormAccount.getScore());
		}
		if( fields.contains("level") ) {
			this.setLevel(ormAccount.getLevel());
		}
		if( fields.contains("createTime") ) {
			this.setCreateTime(ormAccount.getCreateTime());
		}
		if( fields.contains("status") ) {
			this.setStatus(ormAccount.getStatus());
		}		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Integer getNid() {
//		return nid;
//	}
//
//	public void setNid(Integer nid) {
//		this.nid = nid;
//	}
//
//	public String getSid() {
//		return sid;
//	}
//
//	public void setSid(String sid) {
//		this.sid = sid;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

//	public String getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(String question) {
//		this.question = question;
//	}
//
//	public String getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(String answer) {
//		this.answer = answer;
//	}
//
//	public String getMailbox() {
//		return mailbox;
//	}
//
//	public void setMailbox(String mailbox) {
//		this.mailbox = mailbox;
//	}
//
//	public String getWxOpenid() {
//		return wxOpenid;
//	}
//
//	public void setWxOpenid(String wxOpenid) {
//		this.wxOpenid = wxOpenid;
//	}
//
//	public String getWxSessionkey() {
//		return wxSessionkey;
//	}
//
//	public void setWxSessionkey(String wxSessionkey) {
//		this.wxSessionkey = wxSessionkey;
//	}
//
//	public String getWxUnionid() {
//		return wxUnionid;
//	}
//
//	public void setWxUnionid(String wxUnionid) {
//		this.wxUnionid = wxUnionid;
//	}
//
//	public String getWxNickname() {
//		return wxNickname;
//	}
//
//	public void setWxNickname(String wxNickname) {
//		this.wxNickname = wxNickname;
//	}
//
//	public String getWxAvatar() {
//		return wxAvatar;
//	}
//
//	public void setWxAvatar(String wxAvatar) {
//		this.wxAvatar = wxAvatar;
//	}
//
//	public Integer getWxGender() {
//		return wxGender;
//	}
//
//	public void setWxGender(Integer wxGender) {
//		this.wxGender = wxGender;
//	}
//
//	public String getWxCity() {
//		return wxCity;
//	}
//
//	public void setWxCity(String wxCity) {
//		this.wxCity = wxCity;
//	}
//
//	public String getWxCountry() {
//		return wxCountry;
//	}
//
//	public void setWxCountry(String wxCountry) {
//		this.wxCountry = wxCountry;
//	}
//
//	public String getWxProvince() {
//		return wxProvince;
//	}
//
//	public void setWxProvince(String wxProvince) {
//		this.wxProvince = wxProvince;
//	}
//
//	public String getWxLanguage() {
//		return wxLanguage;
//	}
//
//	public void setWxLanguage(String wxLanguage) {
//		this.wxLanguage = wxLanguage;
//	}
//
//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}
//
//	public Integer getGrade() {
//		return grade;
//	}
//
//	public void setGrade(Integer grade) {
//		this.grade = grade;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public Long getScore() {
//		return score;
//	}
//
//	public void setScore(Long score) {
//		this.score = score;
//	}
//
//	public Integer getLevel() {
//		return level;
//	}
//
//	public void setLevel(Integer level) {
//		this.level = level;
//	}
//
//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//
//	public Integer getStatus() {
//		return status;
//	}
//
//	public void setStatus(Integer status) {
//		this.status = status;
//	}
	
}
