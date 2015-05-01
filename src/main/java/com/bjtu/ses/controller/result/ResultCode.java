package com.bjtu.ses.controller.result;

public class ResultCode {

	/** 不允许实例化 */
	private ResultCode() {
		super();
	}

	/** 成功-正常 */
	public static final String S00 = "S00";

	/** 操作员尚未登录或者登录超时 */
	public static final String O01 = "O01";
	/** 操作员用户名错误 */
	public static final String O02 = "O02";
	/** 操作员密码错误 */
	public static final String O03 = "O03";

}
