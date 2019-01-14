package cn.com.iherpai.common.consts;

import java.util.Map;

public class GroupConfig {
	private Boolean		createDelay;
	private Integer 	createDelayValue;
	private Integer		createDelayText;
	private String		createDelayUnitText;
	
	private Boolean		customIcon;
	
	private Boolean		fansBottomLine;
	private Integer		fansBottomLineValue;
	private Boolean		topicBottomLine;
	private Integer		topicBottomLineValue;
	
	private Boolean		groupsTopLine;
	private Integer		groupsTopLineDefaultValue;
	private	Map<Integer,Integer> 	groupsTopLineConfig;
	
	private Boolean		memberTopLine;
	private Integer		memberTopLineDefaultValue;
	private Map<Integer,Integer>	memberTopLineConfig;
	
	public Boolean getCreateDelay() {
		return createDelay;
	}
	public void setCreateDelay(Boolean createDelay) {
		this.createDelay = createDelay;
	}
	public Integer getCreateDelayValue() {
		return createDelayValue;
	}
	public void setCreateDelayValue(Integer createDelayValue) {
		this.createDelayValue = createDelayValue;
	}
	public Integer getCreateDelayText() {
		return createDelayText;
	}
	public void setCreateDelayText(Integer createDelayText) {
		this.createDelayText = createDelayText;
	}
	public String getCreateDelayUnitText() {
		return createDelayUnitText;
	}
	public void setCreateDelayUnitText(String createDelayUnitText) {
		this.createDelayUnitText = createDelayUnitText;
	}
	public Boolean getCustomIcon() {
		return customIcon;
	}
	public void setCustomIcon(Boolean customIcon) {
		this.customIcon = customIcon;
	}
	public Boolean getFansBottomLine() {
		return fansBottomLine;
	}
	public void setFansBottomLine(Boolean fansBottomLine) {
		this.fansBottomLine = fansBottomLine;
	}
	public Integer getFansBottomLineValue() {
		return fansBottomLineValue;
	}
	public void setFansBottomLineValue(Integer fansBottomLineValue) {
		this.fansBottomLineValue = fansBottomLineValue;
	}
	public Boolean getTopicBottomLine() {
		return topicBottomLine;
	}
	public void setTopicBottomLine(Boolean topicBottomLine) {
		this.topicBottomLine = topicBottomLine;
	}
	public Integer getTopicBottomLineValue() {
		return topicBottomLineValue;
	}
	public void setTopicBottomLineValue(Integer topicBottomLineValue) {
		this.topicBottomLineValue = topicBottomLineValue;
	}
	public Boolean getGroupsTopLine() {
		return groupsTopLine;
	}
	public void setGroupsTopLine(Boolean groupsTopLine) {
		this.groupsTopLine = groupsTopLine;
	}
	public Integer getGroupsTopLineDefaultValue() {
		return groupsTopLineDefaultValue;
	}
	public void setGroupsTopLineDefaultValue(Integer groupsTopLineDefaultValue) {
		this.groupsTopLineDefaultValue = groupsTopLineDefaultValue;
	}
	public Map<Integer, Integer> getGroupsTopLineConfig() {
		return groupsTopLineConfig;
	}
	public void setGroupsTopLineConfig(Map<Integer, Integer> groupsTopLineConfig) {
		this.groupsTopLineConfig = groupsTopLineConfig;
	}
	public Boolean getMemberTopLine() {
		return memberTopLine;
	}
	public void setMemberTopLine(Boolean memberTopLine) {
		this.memberTopLine = memberTopLine;
	}
	public Integer getMemberTopLineDefaultValue() {
		return memberTopLineDefaultValue;
	}
	public void setMemberTopLineDefaultValue(Integer memberTopLineDefaultValue) {
		this.memberTopLineDefaultValue = memberTopLineDefaultValue;
	}
	public Map<Integer, Integer> getMemberTopLineConfig() {
		return memberTopLineConfig;
	}
	public void setMemberTopLineConfig(Map<Integer, Integer> memberTopLineConfig) {
		this.memberTopLineConfig = memberTopLineConfig;
	}
	
}
