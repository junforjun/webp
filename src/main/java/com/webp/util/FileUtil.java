package com.webp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	public static byte[] inputStreamToByteArray(InputStream is) {

	    byte[] resBytes = null;
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();

	    byte[] buffer = new byte[1024];
	    int read = -1;
	    try {
	        while ( (read = is.read(buffer)) != -1 ) {
	           bos.write(buffer, 0, read);
	        }

	        resBytes = bos.toByteArray();
	        bos.close();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return resBytes;
	}

}
