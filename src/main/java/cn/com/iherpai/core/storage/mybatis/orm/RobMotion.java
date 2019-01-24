package cn.com.iherpai.core.storage.mybatis.orm;

import java.io.Serializable;

public class RobMotion extends Entity implements Serializable {
	private static final long serialVersionUID = 3608215655854602803L;
	
	private Long		id;
	private Integer		nid;
	private String		sid;
	private Integer		type;
	private Integer		typeAlpha;
	private Integer		typeBeta;
	private String		name;
	private String		code;
	private Boolean		canBreak;
	private Boolean		needSecond;
	private Boolean		canDebate;
	private Boolean		canModify;
	private Boolean		canRediscuss;
	private Integer		minPoll;
	
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getTypeAlpha() {
		return typeAlpha;
	}
	public void setTypeAlpha(Integer typeAlpha) {
		this.typeAlpha = typeAlpha;
	}
	public Integer getTypeBeta() {
		return typeBeta;
	}
	public void setTypeBeta(Integer typeBeta) {
		this.typeBeta = typeBeta;
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
	public Boolean getCanBreak() {
		return canBreak;
	}
	public void setCanBreak(Boolean canBreak) {
		this.canBreak = canBreak;
	}
	public Boolean getNeedSecond() {
		return needSecond;
	}
	public void setNeedSecond(Boolean needSecond) {
		this.needSecond = needSecond;
	}
	public Boolean getCanDebate() {
		return canDebate;
	}
	public void setCanDebate(Boolean canDebate) {
		this.canDebate = canDebate;
	}
	public Boolean getCanModify() {
		return canModify;
	}
	public void setCanModify(Boolean canModify) {
		this.canModify = canModify;
	}
	public Boolean getCanRediscuss() {
		return canRediscuss;
	}
	public void setCanRediscuss(Boolean canRediscuss) {
		this.canRediscuss = canRediscuss;
	}
	public Integer getMinPoll() {
		return minPoll;
	}
	public void setMinPoll(Integer minPoll) {
		this.minPoll = minPoll;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
