package com.bjtu.ses.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseController {
	public List<Map<String, Object>> getByCursor(
			List<Map<String, Object>> list, int page, int rows) {
		return list.stream().skip((page - 1) * rows).limit(rows)
				.collect(Collectors.toList());
	}
}
