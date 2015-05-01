package com.bjtu.ses.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DigestUtil {
	private static final String MD5_ALGORITHM_NAME = "MD5";
	private static final String SHA1_ALGORITHM_NAME = "SHA-1";

	public static byte[] md5Digest(byte[] bytes) {
		return digest(MD5_ALGORITHM_NAME, bytes);
	}

	public static byte[] sha1Digest(byte[] bytes) {
		return digest(SHA1_ALGORITHM_NAME, bytes);
	}

	public static String md5DigestAsHex(byte[] bytes) {
		return digestAsHexString(MD5_ALGORITHM_NAME, bytes);
	}

	public static String sha1DigestAsHex(byte[] bytes) {
		return digestAsHexString(SHA1_ALGORITHM_NAME, bytes);
	}

	public static String digestAsHex(String algorithm, byte[] bytes) {
		return digestAsHexString(algorithm, bytes);
	}

	private static MessageDigest getDigest(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException ex) {
			throw new IllegalStateException(
					"Could not find MessageDigest with algorithm \""
							+ algorithm + "\"", ex);
		}
	}

	private static byte[] digest(String algorithm, byte[] bytes) {
		return getDigest(algorithm).digest(bytes);
	}

	private static String digestAsHexString(String algorithm, byte[] bytes) {
		byte[] digest = digest(algorithm, bytes);
		return toHex(digest).toUpperCase();
	}

	public static String hmacSign(String aValue, String aKey) {
		byte[] k_ipad = new byte[64];
		byte[] k_opad = new byte[64];
		byte[] keyb;
		byte[] value;
		try {
			keyb = aKey.getBytes("UTF-8");
			value = aValue.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			keyb = aKey.getBytes();
			value = aValue.getBytes();
		}

		Arrays.fill(k_ipad, keyb.length, 64, (byte) 54);
		Arrays.fill(k_opad, keyb.length, 64, (byte) 92);
		for (int i = 0; i < keyb.length; i++) {
			k_ipad[i] = (byte) (keyb[i] ^ 0x36);
			k_opad[i] = (byte) (keyb[i] ^ 0x5C);
		}

		MessageDigest md = getDigest(MD5_ALGORITHM_NAME);
		md.update(k_ipad);
		md.update(value);
		byte[] dg = md.digest();
		md.reset();
		md.update(k_opad);
		md.update(dg, 0, 16);
		dg = md.digest();
		return toHex(dg);
	}

	public static boolean hmacVerify(String aValue, String aKey, String aHmac) {
		return hmacSign(aValue, aKey).equals(aHmac);
	}

	private static String toHex(byte[] input) {
		if (input == null)
			return null;
		StringBuffer output = new StringBuffer(input.length * 2);
		for (int i = 0; i < input.length; i++) {
			int current = input[i] & 0xFF;
			if (current < 16)
				output.append("0");
			output.append(Integer.toString(current, 16));
		}

		return output.toString();
	}
}
