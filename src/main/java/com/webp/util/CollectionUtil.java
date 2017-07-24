package com.webp.util;

import java.util.List;

public class CollectionUtil {
	public static boolean isNull(List<?> list) {
		return list == null || list.size() == 0 ? true : false;
	}

}
