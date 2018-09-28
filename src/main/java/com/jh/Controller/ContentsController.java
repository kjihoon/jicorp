package com.jh.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jh.Service.ContentsService;
import com.jh.common.CommandMap;

@Controller
public class ContentsController {
	@Autowired
	ContentsService contentService;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/load/contents")
	public String loadContents(CommandMap params,HttpServletRequest req) {
		req.setAttribute("center", "load");
		return "blog/index";
	}
	
	@RequestMapping(value="/create/contents" ,produces = "text/html; charset=utf8",method=RequestMethod.GET) // POST
	public String createContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){
		try{
			log.debug(params.getMap().toString());
			contentService.insertContents(params.getMap());
		}catch(Exception e) {
			redirectAttributes.addAttribute("msg", "contents 생성에 실패하였습니다.");
			return "redirect:/main/error";
		}
		return "redirect:/main/index";
	}
	@RequestMapping("/selectlist/contents")
	@ResponseBody
	public String selectContentsList() throws Exception {
		List<Map<String,Object>> result =contentService.selectContentsList();
		return result.toString();
	}
	@RequestMapping("/select/content")
	public String selectContents(CommandMap params,HttpServletRequest req) throws Exception {
		Map<String,Object> content =contentService.selectContentsOne(params.getMap());
		log.info(params.getMap().toString());
		log.info(content.toString());
		req.setAttribute("content", content);
		req.setAttribute("center","post");
		return "blog/index";
	}
	

}
