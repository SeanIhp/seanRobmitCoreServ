package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import cn.com.iherpai.core.storage.mybatis.orm.Account;

public class AccountVo extends Account implements Serializable {
	private static final long serialVersionUID = 3094336313759441343L;

	private String			newPassword;		

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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
