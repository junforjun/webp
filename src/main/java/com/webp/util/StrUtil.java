package com.webp.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Pattern;

import javax.mail.internet.MimeUtility;

public class StrUtil {

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

	public static String getLastUrl(String url) {
		if (isEmpty(url)) {
			return null;
		}

		String[] strArr = url.split("/");



		return null;
	}

	public static boolean isEmail(String email) {
        if (email==null) return false;
        boolean b = Pattern.matches(
            "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",
            email.trim());
        return b;
    }

	public static String getRandomPassword( int length ){
        char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        StringBuffer sb = new StringBuffer();
        Random rn = new Random();
        for( int i = 0 ; i < length ; i++ ){
            sb.append( charaters[ rn.nextInt( charaters.length ) ] );
        }
        return sb.toString();
    }


}
