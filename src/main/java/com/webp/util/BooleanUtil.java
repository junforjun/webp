package com.webp.util;

public class BooleanUtil {
	public static String toFlag(String str) {
		return Boolean.valueOf(str) ? "1" : "0";
	}

	public static String toFlag(boolean bool) {
		return bool ? "1" :  "0";
	}
}
