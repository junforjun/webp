package com.webp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webp.service.WriteUserBlogService;

public class Log {
	private static final Logger logger = LoggerFactory.getLogger(WriteUserBlogService.class);

	public static void debug(String message) {

		logger.debug(message);
	}

	public static void info(String message) {
		logger.info(message);
	}

	public static void vipLog(String message) {
		logger.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
		logger.info(message);
		logger.info("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
	}
}
