package com.jh.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/filetestpage")
	public String filetestpage() {
		return "blog/fileloadtest";
	}
	
	@RequestMapping("/filetest")
	@ResponseBody
	public String filetest(@RequestParam("img") MultipartFile img,HttpServletRequest req) {
		
		String path = req.getSession().getServletContext().getRealPath("/resources/img");
		log.info(req.getSession().getServletContext().getRealPath("\\"));
		boolean flag = true;
	    if (!img.isEmpty()) {
	    	String originalFilename = img.getOriginalFilename(); // fileName.jpg
	        path =  path+"\\"+originalFilename;
	        BufferedOutputStream stream = null;
	        try {
	            byte[] bytes = img.getBytes();
	            log.debug(System.getProperty("catalina.base"));
	            stream= new BufferedOutputStream(new FileOutputStream(new File(System.getProperty("catalina.base")+"/webapps/ROOT/"+originalFilename) ));
	            stream.write(bytes);
	        } catch (Exception e) {
	        	log.error(e.getMessage());
	        	flag = false;
	        } finally {
	        	if (stream!=null) {
	        		try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	        	}
	        }
	    } else {
	    	flag = false;
	    }
		return "result";
	}
}
