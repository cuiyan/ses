package com.bjtu.ses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.bjtu.ses.enums.ConfigType;
@Entity
@Table(name = "SES_CONFIG")
public class SESConfig extends AutoIDEntity {
	/**
	 * 配置KEY
	 */
	private String configKey;
	/**
	 * 配置Value
	 */
	private String configVal;
	/**
	 * 级别编号
	 */
	private Integer level;
	/**
	 * 父级别编号
	 */
	private Integer PLevel;
	/**
	 * 配置类型
	 */
	private ConfigType configType;

	@Column(name = "CONGIFKEY")
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	@Column(name = "CONFIGVALUE")
	public String getConfigVal() {
		return configVal;
	}
	public void setConfigVal(String configVal) {
		this.configVal = configVal;
	}
	@Column(name = "LEVEL")
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Column(name = "PLEVEL")
	public Integer getPLevel() {
		return PLevel;
	}
	public void setPLevel(Integer pLevel) {
		PLevel = pLevel;
	}
	@Enumerated(value = EnumType.STRING)
	@Column(name = "CONFIGTYPE")
	public ConfigType getConfigType() {
		return configType;
	}
	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

}
