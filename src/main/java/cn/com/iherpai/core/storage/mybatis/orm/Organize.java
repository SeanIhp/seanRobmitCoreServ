package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;
import java.util.Date;

public class Organize extends Entity implements Serializable {
	private static final long serialVersionUID = -4113474425569807163L;
	
	private Long		id;
	private Integer		nid;
	private String		sid;
	private String		name;
	private String		code;
	private String		icon;
	private String		intro;
	private Integer		total;
	private Integer		settingMessage;
	private Boolean		settingTop;
	private Integer		settingJoin;
	private Integer		settingVisit;
	private Integer		settingSpeak;
	private Integer		level;
	private Date		createTime;
	private Integer		status;
	
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSettingMessage() {
		return settingMessage;
	}
	public void setSettingMessage(Integer settingMessage) {
		this.settingMessage = settingMessage;
	}
	public Boolean getSettingTop() {
		return settingTop;
	}
	public void setSettingTop(Boolean settingTop) {
		this.settingTop = settingTop;
	}
	public Integer getSettingJoin() {
		return settingJoin;
	}
	public void setSettingJoin(Integer settingJoin) {
		this.settingJoin = settingJoin;
	}
	public Integer getSettingVisit() {
		return settingVisit;
	}
	public void setSettingVisit(Integer settingVisit) {
		this.settingVisit = settingVisit;
	}
	public Integer getSettingSpeak() {
		return settingSpeak;
	}
	public void setSettingSpeak(Integer settingSpeak) {
		this.settingSpeak = settingSpeak;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
