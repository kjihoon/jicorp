package com.jh.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jh.Service.ContentsService;
import com.jh.common.CommandMap;

@Controller
public class ContentsController {
	@Autowired
	ContentsService contentservice;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/load/contents")
	public String loadContents() {
		
		return "post";
	}
	
	@RequestMapping(value="/create/contents" ,method=RequestMethod.GET) // POST
	public String createContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){
		Map<String, Object> map = params.getMap();
		JSONObject jo = new JSONObject(map);
		try{
			log.debug(map.toString());
			contentservice.insertContents(map);
		}catch(Exception e) {
			redirectAttributes.addAttribute("msg", "contents 생성에 실패하였습니다.");
			return "redirect:/main/error";
		}
		return "index";
	}
	
	@RequestMapping("/select/content")
	public String selectContents(CommandMap params,HttpServletRequest req) throws Exception {
		Map<String,Object> content =contentservice.selectContentsOne(params.getMap());
		log.info(params.getMap().toString());
		log.info(content.toString());
		req.setAttribute("content", content);
		req.setAttribute("center","in");
		return "blog/index";
	}
	

}
