package com.jh.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jh.common.CommandMap;

@Controller
public class ManagerController {
	
	
	
	Logger log = Logger.getLogger(this.getClass());
	@RequestMapping("/manager/res")
	public String res(RedirectAttributes redirectAttributes,HttpSession sess) {
		String master = (String) sess.getAttribute("master");
		if (!master.equals("on")) {
			return "redirect:/main/index";
		}
		return "/manager/res";
	}
	
	
	@RequestMapping(value="/manager/dev", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String dev(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes,HttpSession sess) {
		String master = (String) sess.getAttribute("master");
		if (!master.equals("on")) {
			return "incorrect req";
		}
		
		String reqPath = (String) req.getParameter("path");
		log.debug("aftef: " + reqPath);
		JSONObject jo = new JSONObject();
		JSONArray F = new JSONArray();
		JSONArray D = new JSONArray();
		File folder=null;
		//운영 서버
		if ("/var/lib/tomcat8".equals(System.getProperty("catalina.base"))) {
			 folder = new File(System.getProperty("catalina.base")+"/webapps/ROOT"+reqPath);
		//개발 서버
        }else {
    	    folder = new File(System.getProperty("catalina.base")+"/wtpwebapps/ROOT"+reqPath);
        }
		 File[] listOfFiles = folder.listFiles();
  	   
  	   
  	   for (int i = 0; i < listOfFiles.length; i++) {
  	     if (listOfFiles[i].isFile()) {
  	       log.info("File " + listOfFiles[i].getName());
  	       F.add("/"+listOfFiles[i].getName());
  	     } else if (listOfFiles[i].isDirectory()) {
  	       log.info("Directory " + listOfFiles[i].getName());
  	       D.add("/"+listOfFiles[i].getName());
  	     }
  	   }
		jo.put("F", F);
  	    jo.put("D", D);
		return jo.toJSONString();
	}
	
	
	
	@RequestMapping(value="/manager/delete", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String delete(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes,HttpSession sess) {
		String master = (String) sess.getAttribute("master");
		if (!master.equals("on")) {
			return "incorrect req";
		}
		String reqPath = (String) req.getParameter("path");
		log.debug("aftee: " + reqPath);
		File file=null;
		//운영 서버
		if ("/var/lib/tomcat8".equals(System.getProperty("catalina.base"))) {
			file = new File(System.getProperty("catalina.base")+"/webapps/ROOT"+reqPath);
		//개발 서버
        }else {
        	file = new File(System.getProperty("catalina.base")+"/wtpwebapps/ROOT"+reqPath);
        }
		JSONObject jo = new JSONObject();
		if(file.delete()) {
			jo.put("flag", true);
		}else {
			jo.put("flag", false);
		}		
		
		return jo.toJSONString();
	}
	
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value ="/manager/uploadfile", method=RequestMethod.POST , produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String uploadfile(@RequestParam("uploadfile") MultipartFile uploadfile,HttpServletRequest req) {
		
		
		JSONObject jo = new JSONObject();
		boolean flag = true;
		String originalFilename = "";
		String path = (String)req.getParameter("path");
	    if (!uploadfile.isEmpty()) {
	    	originalFilename = uploadfile.getOriginalFilename(); // fileName.jpg
	        BufferedOutputStream stream = null;
	        try {
	            byte[] bytes = uploadfile.getBytes();
	            File file= null;
	            if ( "/var/lib/tomcat8".equals(System.getProperty("catalina.base"))) {
	            	 //운영 서버
	            	log.debug("운영 서버 자원 업로드");
	            	 file = new File(System.getProperty("catalina.base")+"/webapps/ROOT"+path+"/"+originalFilename);
	            	
	            }else {
	            	//개발 서버
	            	log.debug("개발 서버 자원 업로드");
	            	 file =new File(System.getProperty("catalina.base")+"/wtpwebapps/ROOT"+path+"/"+originalFilename);
	            }
	            if (file.isFile()) {
            		log.info("img upload result:  "+false);
            		 jo.put("flag", false);
            		 jo.put("originalFilename", originalFilename+ ": 이미 존재하는 파일명");
            		return jo.toJSONString();
            	}
	            stream= new BufferedOutputStream(new FileOutputStream(file));
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
	    	originalFilename = originalFilename + "업로드 실패";
	    	return "fail";
	    }
	    log.info("img upload result:  "+flag);
	    
	    jo.put("flag", flag);
	    jo.put("originalFilename", originalFilename);
		return jo.toJSONString();
	}
	
	
	
	
}
