package com.webp.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {


	public static String dateToStr(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

	}

	public static Timestamp getCurrentTimeStamp() {
		return Timestamp.valueOf(LocalDateTime.now());
	}

	public static Timestamp addMin(Timestamp t, int m) {

		LocalDateTime ldt = t.toLocalDateTime();
		ldt.plusMinutes(m);

		return Timestamp.valueOf(ldt);

	}

}
