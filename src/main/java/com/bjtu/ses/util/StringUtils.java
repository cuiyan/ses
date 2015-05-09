package com.bjtu.ses.util;

public class StringUtils {

	/**
	 * 根据记录条数获取对应格式的编码
	 * 
	 * @param count
	 * @return
	 */
	public static String getLastCode(int count) {
		String s = "";
		if (count / 10 == 0) {
			s = "00" + count + "";
		} else if (count / 100 == 0) {
			s = "0" + count + "";
		} else {
			s = count + "";
		}
		return s;
	}
	/**
	 * 根据记录条数获取对应格式的编码
	 * 
	 * @param count
	 * @return
	 */
	public static String getFiveLengthCode(int count) {
		String s = "";
		if (count / 10 == 0) {
			s = "0000" + count + "";
		} else if (count / 100 == 0) {
			s = "000" + count + "";
		} else if (count / 1000 == 0) {
			s = "00" + count + "";
		} else if (count / 10000 == 0) {
			s = "0" + count + "";
		} else {
			s = count + "";
		}
		return s;
	}
	public static void main(String[] args) {
		System.out.println(StringUtils.getFiveLengthCode(876));
	}
}
