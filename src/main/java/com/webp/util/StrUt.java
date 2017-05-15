package com.webp.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

import javax.mail.internet.MimeUtility;

public class StrUt {

	/**
	 * 数値判定Util
	 *
	 * @param str
	 *            文字列
	 * @return false : 文字 true : 数字
	 */
	public static boolean isNumber(String str) {

		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static boolean isEmpty(String s) {
		return s == null || s.equals("") ? true : false;
	}

	public static boolean isNotEmpty(String s) {
		return s == null || s.equals("") ? false : true;
	}

	public static String digestString(String pass) throws Exception {

		MessageDigest md;
		ByteArrayOutputStream bos;
		md = MessageDigest.getInstance("SHA");
		byte[] digest = md.digest(pass.getBytes("iso-8859-1"));
		bos = new ByteArrayOutputStream();
		OutputStream encodedStream = MimeUtility.encode(bos, "base64");
		encodedStream.write(digest);

		return bos.toString("iso-8859-1");
	}
}
