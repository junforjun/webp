package com.webp.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {


	public static String dateToStr(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

	}
}
