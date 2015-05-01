package com.bjtu.ses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ses.dao.SESConfigDao;
import com.bjtu.ses.entity.SESConfig;
import com.bjtu.ses.enums.ConfigType;
import com.bjtu.ses.service.SESConfigService;
@Service
public class SESConfigServiceImpl implements SESConfigService {
	@Resource
	private SESConfigDao sesConfigDao;
	@Override
	public List<SESConfig> getList(ConfigType configType) {
		return sesConfigDao.getList(configType);
	}
	public List<SESConfig> getList(ConfigType configType, Integer pLevel) {
		return sesConfigDao.getList(configType, pLevel);
	}
	public SESConfig getByConfigKey(String configKey, Integer pLevel) {
		return sesConfigDao.getByConfigKey(configKey, pLevel);
	}
}
