package com.jh.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jh.Service.PicturesService;

@Controller
public class FileController {
	Logger log = Logger.getLogger(this.getClass());
	
	@SuppressWarnings("unused")
	@RequestMapping(value ="/imgload", method=RequestMethod.POST , produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String imgload(@RequestParam("img") MultipartFile img,HttpServletRequest req) {
		
		Map<String,Object> picture = new HashMap<>();
		
		
		boolean flag = true;
		String originalFilename = "";
	    if (!img.isEmpty()) {
	    	originalFilename = img.getOriginalFilename(); // fileName.jpg
	        BufferedOutputStream stream = null;
	        try {
	            byte[] bytes = img.getBytes();
	           
	            if ( "/var/lib/tomcat8".equals(System.getProperty("catalina.base"))) {
	            	 //운영 서버
	            	log.debug("운영 서버 자원 업로드");
	            	File file = new File(System.getProperty("catalina.base")+"/webapps/ROOT/"+originalFilename);
	            	if (file.isFile()) {return "이미 존재하는 파일(동일한 이름 포함)";}
	            	stream= new BufferedOutputStream(new FileOutputStream(file));
	            }else {
	            	//개발 서버
	            	log.debug("개발 서버 자원 업로드");
	            	File file =new File(System.getProperty("catalina.base")+"/wtpwebapps/ROOT/res/img/"+originalFilename);
	            	if (file.isFile()) {return "이미 존재하는 파일(동일한 이름 포함)";}
		            stream= new BufferedOutputStream(new FileOutputStream(file));
	            }
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
	    	return "fail";
	    }
	    log.info("img upload result:  "+flag);
	    
		return originalFilename;
	}
}
