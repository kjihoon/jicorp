package com.jh.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jh.common.CommandMap;

@Controller
public class OpinionController {

	//@Autowired
	//ContentsService contentService;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/load/opinion")
	public String loadOpinion(HttpServletRequest req) {
		req.setAttribute("center", "opinion");
		
		return "blog/index";
	}
	
	@RequestMapping(value="/create/opinion" ,produces = "text/html; charset=utf8",method=RequestMethod.POST) // POST
	public String createOpinion(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){
		try{
			//contentService.insertContents(params.getMap());
			log.info(params.getMap().toString());
		}catch(Exception e) {
			log.error(e.getMessage());
			redirectAttributes.addAttribute("msg", "opinion 생성에 실패하였습니다.");
			return "redirect:/main/error";
		}
		return "redirect:/main/index";
	}
}
