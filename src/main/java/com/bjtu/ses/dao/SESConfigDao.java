package com.bjtu.ses.dao;

import java.util.List;

import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.enums.ConfigType;

public interface SESConfigDao {
	public List<SESConfig> getList(ConfigType configType);
	public List<SESConfig> getList(ConfigType configType, Integer pLevel);
	public SESConfig getByConfigKey(String configKey, Integer pLevel, ConfigType configType);
}
