package com.jh.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.Service.ContentsService;

@Controller
public class MainController {
	@Autowired
	ContentsService contentservice;
	
	
	Logger log = Logger.getLogger(this.getClass());
	/*@RequsetMapping("/main")
	public String funcName() {
		return ""
	}*/
	
	
	@RequestMapping("/main/index")
	public String mainIndex(HttpServletRequest req) throws Exception {
		JSONObject jo = new JSONObject();
		List<Map<String,Object>> result =contentservice.selectContentsList();
		//req.setAttribute("contentscount",result.size());
		req.setAttribute("contents",result);
		
		return "blog/index";
	}
	@RequestMapping("/selectlist/contents")
	@ResponseBody
	public String selectContentsList() throws Exception {
		JSONObject jo = new JSONObject();
		List<Map<String,Object>> result =contentservice.selectContentsList();
		return result.toString();
	}
	
	
	
	/*REDIRECT METHOD*/
	@RequestMapping("/main/error")
	public String mainError(@RequestParam("msg") String msg,HttpServletRequest req) {
		req.setAttribute("msg", msg);
		return "blog/index";
	}
}
