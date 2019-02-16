package cn.com.iherpai.core.vo;

import java.io.Serializable;

import cn.com.iherpai.core.storage.mybatis.orm.Meeting;

public class MeetingVo extends Meeting implements Serializable {
	private static final long serialVersionUID = 8042421703461742465L;
	
	private Integer			levelMin;
	private Integer			levelMax;
	private Integer			levelAlphaMin;
	private Integer			levelAlphaMax;
	private Integer			levelBetaMin;
	private Integer			levelBetaMax;
	private Integer			levelCharlieMin;
	private Integer			levelCharlieMax;
	private Integer			minJoinMin;
	private Integer			minJoinMax;
	private Integer			invitedCountMin;
	private Integer			invitedCountMax;
	private Integer			joinedCountMin;
	private Integer			joinedCountMax;
	private Integer			statusMin;
	private Integer			statusMax;
	
	public Integer getLevelMin() {
		return levelMin;
	}
	public void setLevelMin(Integer levelMin) {
		this.levelMin = levelMin;
	}
	public Integer getLevelMax() {
		return levelMax;
	}
	public void setLevelMax(Integer levelMax) {
		this.levelMax = levelMax;
	}
	public Integer getLevelAlphaMin() {
		return levelAlphaMin;
	}
	public void setLevelAlphaMin(Integer levelAlphaMin) {
		this.levelAlphaMin = levelAlphaMin;
	}
	public Integer getLevelAlphaMax() {
		return levelAlphaMax;
	}
	public void setLevelAlphaMax(Integer levelAlphaMax) {
		this.levelAlphaMax = levelAlphaMax;
	}
	public Integer getLevelBetaMin() {
		return levelBetaMin;
	}
	public void setLevelBetaMin(Integer levelBetaMin) {
		this.levelBetaMin = levelBetaMin;
	}
	public Integer getLevelBetaMax() {
		return levelBetaMax;
	}
	public void setLevelBetaMax(Integer levelBetaMax) {
		this.levelBetaMax = levelBetaMax;
	}
	public Integer getLevelCharlieMin() {
		return levelCharlieMin;
	}
	public void setLevelCharlieMin(Integer levelCharlieMin) {
		this.levelCharlieMin = levelCharlieMin;
	}
	public Integer getLevelCharlieMax() {
		return levelCharlieMax;
	}
	public void setLevelCharlieMax(Integer levelCharlieMax) {
		this.levelCharlieMax = levelCharlieMax;
	}
	public Integer getMinJoinMin() {
		return minJoinMin;
	}
	public void setMinJoinMin(Integer minJoinMin) {
		this.minJoinMin = minJoinMin;
	}
	public Integer getMinJoinMax() {
		return minJoinMax;
	}
	public void setMinJoinMax(Integer minJoinMax) {
		this.minJoinMax = minJoinMax;
	}
	public Integer getInvitedCountMin() {
		return invitedCountMin;
	}
	public void setInvitedCountMin(Integer invitedCountMin) {
		this.invitedCountMin = invitedCountMin;
	}
	public Integer getInvitedCountMax() {
		return invitedCountMax;
	}
	public void setInvitedCountMax(Integer invitedCountMax) {
		this.invitedCountMax = invitedCountMax;
	}
	public Integer getJoinedCountMin() {
		return joinedCountMin;
	}
	public void setJoinedCountMin(Integer joinedCountMin) {
		this.joinedCountMin = joinedCountMin;
	}
	public Integer getJoinedCountMax() {
		return joinedCountMax;
	}
	public void setJoinedCountMax(Integer joinedCountMax) {
		this.joinedCountMax = joinedCountMax;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
