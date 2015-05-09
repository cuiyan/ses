package com.bjtu.ses.model;

import java.util.Map;

import com.google.common.collect.Maps;

public class JsonResultView {

	/**
	 * 可以做池化，防止产生过多的对象。
	 */
	private final Map<String, Object> data;

	public JsonResultView(boolean success, Object msg) {
		data = Maps.newHashMap();
		data.put("success", success);
		data.put("msg", msg);
	}

	public static Map<String, Object> ofSeccess(Object msg) {
		return new JsonResultView(true, msg).getData();
	}

	public static Map<String, Object> ofFalse(Object msg) {
		return new JsonResultView(false, msg).getData();
	}

	public Map<String, Object> getData() {
		return data;
	}

}
