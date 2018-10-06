package com.jh.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jh.Service.ContentsService;
import com.jh.common.CommandMap;
import com.jh.common.Msg;

@Controller
public class ContentsController extends Msg{
	@Autowired
	ContentsService contentService;
	
	Logger log = Logger.getLogger(this.getClass());
	
	
	/* NEW CONETNT PAGE */
	@RequestMapping("/load/contents")
	public String loadContents(CommandMap params,HttpServletRequest req) {
		req.setAttribute("center", "load");
		return "blog/index";
	}
	/* REVISE CONTENT  PAGE*/
	@RequestMapping("/edit/contents")
	public String editContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes) {
		Map<String,Object> content = contentService.selectContentsOne(params.getMap());
		if (content == null) {
			redirectAttributes.addAttribute("msg", "contents"+SELECT_MSG_ERROR);
			return "redirect:/main/index";
		}		
		req.setAttribute("center", "edit");
		req.setAttribute("content", content);
		return "blog/index";
	}
	
	
	
	/* CREATE CONETNS */
	@SuppressWarnings("unused")
	@RequestMapping(value="/create/contents" ,produces = "text/html; charset=utf8",method=RequestMethod.POST) // POST
	public String createContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){
		Object result = contentService.insertContents(params.getMap());
		if (result == null) {
			redirectAttributes.addAttribute("msg", "content"+INSERT_MSG_ERROR);
		}
		return "redirect:/main/index";
	}
	
	/* UPDATE CONETNS */
	@SuppressWarnings("unused")
	@RequestMapping(value="/update/contents" ,produces = "text/html; charset=utf8",method=RequestMethod.POST) // POST
	public String updateContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){
		Object result =contentService.updateContents(params.getMap());
		if (result == null) {
			redirectAttributes.addAttribute("msg","content"+UPDATE_MSG_ERROR);
		}
		return "redirect:/main/index";
	}
	
	/* SELECT ONE CONENTES */
	@RequestMapping("/select/content")
	public String selectContents(CommandMap params,HttpServletRequest req,RedirectAttributes redirectAttributes){	
		Map<String,Object> content =contentService.selectContentsOne(params.getMap());
		Map<String,Object> arrow =contentService.selectArrow(params.getMap());
		
		if (content == null||arrow == null) {
			redirectAttributes.addAttribute("msg", "contents"+SELECT_MSG_ERROR);
			return "redirect:/main/index";
		}
		req.setAttribute("arrow", arrow);
		req.setAttribute("content", content);
		req.setAttribute("center","post");
		return "blog/index";
	}
	
	@RequestMapping("/selectlist/contents")
	@ResponseBody
	public String selectContentsList() throws Exception {
		List<Map<String,Object>> result =contentService.selectContentsList();
		return result.toString();
	}
	
	

}
