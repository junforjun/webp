package com.webp.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
	public static Timestamp getCurrentTimeStamp() {
		return Timestamp.valueOf(LocalDateTime.now());
	}

	/**
	 * LocalDateTime to yyyy-MM-dd HH:mm:ss
	 * @param t LocalDateTime
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getStrTime(LocalDateTime t) {
		return t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

	}

	/**
	 * Timestamp to yyyy-MM-dd HH:mm:ss
	 * @param t Timestamp
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getStrTime(Timestamp t) {
		return getStrTime(t.toLocalDateTime());
	}
}
