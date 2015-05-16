package com.bjtu.ses.service;

import java.util.List;

import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.enums.ConfigType;

public interface SESConfigService {
	public List<SESConfig> getList(ConfigType configType);
	public List<SESConfig> getList(ConfigType configType, Integer level);
	public SESConfig getByConfigKey(String getByConfigKey, Integer pLevel, ConfigType configType);
}
