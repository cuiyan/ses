package com.bjtu.ses.controller.result;

import com.bjtu.ses.enums.ResultType;

public class LoginResultBean {
	/**
	 * 处理结果
	 */
	private ResultType type;
	/**
	 * 失败原因
	 */
	private String reason;

	public ResultType getType() {
		return type;
	}

	public void setType(ResultType type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginResultBean [type=");
		builder.append(type);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}
}
