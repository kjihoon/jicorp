package com.jh.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class CommonMethod {
	
	
	Logger log = Logger.getLogger(this.getClass());
	public boolean imgHandle(String path,MultipartFile mpf) {
		log.info("img handle");
		boolean result = true;
	    if (!mpf.isEmpty()) {
	    	
	    	String originalFilename = mpf.getOriginalFilename(); // fileName.jpg
	        path =  path+originalFilename;
	    	
	        try {
	            byte[] bytes = mpf.getBytes();
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
	            stream.write(bytes);
	            stream.close();
	        } catch (Exception e) {
	        	log.error(e.getMessage());
	        	result = false;
	        }
	    } else {
	    		result = false;
	    }
	     
	    return result;
	}
}
