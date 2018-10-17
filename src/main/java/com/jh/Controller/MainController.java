package com.jh.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jh.Service.ContentsService;
import com.jh.Service.PicturesService;
import com.jh.common.CommandMap;
import com.jh.common.Msg;

@Controller
public class MainController implements Msg{
	@Autowired
	ContentsService contentService;
	
	
	
	Logger log = Logger.getLogger(this.getClass());
	
	/*MAIN INDEX PAGE*/
	@RequestMapping("/main/index")
	public String mainIndex(HttpServletRequest req,CommandMap params) {
		final int COUNT = 5; //view count
		int page = 0;  //default page
		String msg = (String) params.get("msg");
		
		try {
			page = params.get("page") ==null? 0:Integer.parseInt((String) params.get("page"));
		}catch(Exception e) {
			msg = "Incorrect Request";
			log.error(e.getMessage());
		}
		// Select Contents List
		Map<String,Integer> pageParam = new HashMap<>();
		pageParam.put("START",page*COUNT);
		pageParam.put("COUNT",COUNT);
		List<Map<String,Object>> contentOne =contentService.selectContentsList(pageParam);
		
		// Select Contents Length
		Map<String,Object> contentlen =contentService.selectContentsLength(new HashMap<String,Object>());

		req.setAttribute("contentlen", contentlen.get("COUNT"));
		req.setAttribute("contents",contentOne);
		req.setAttribute("page", page);
		req.setAttribute("msg", msg);
		return "blog/index";
	}

	
	/*IF OCCUR ERROR , REDIRECT METHOD*/
	@RequestMapping("/main/error")
	public String mainError(@RequestParam(value="msg",required=false) String msg,RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("msg",msg);
		return "redirect:/main/index";
	}
	
	/*MASTER LOGIN*/
	@RequestMapping("/master")
	public String master(@RequestParam("key") String key,HttpServletRequest req,HttpSession sess,RedirectAttributes redirectAttributes) throws Exception {
		if (key.equals("kjihoon0914")) {
			log.info("connect master");
			sess.setAttribute("master", "on");
			redirectAttributes.addAttribute("msg", "MASTER ON");
		}else {
			sess.invalidate();
			log.info("incorrect connection");
			redirectAttributes.addAttribute("msg", "MASTER OFF");
			return "redirect:/main/index";
		}
		
		return "blog/index";
	}
	
	

}
