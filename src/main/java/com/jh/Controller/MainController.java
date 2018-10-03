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

import com.jh.Service.ContentsService;
import com.jh.common.CommandMap;

@Controller
public class MainController {
	@Autowired
	ContentsService contentService;
	
	
	Logger log = Logger.getLogger(this.getClass());
	
	
	@RequestMapping("/main/index")
	public String mainIndex(HttpServletRequest req,CommandMap params) throws Exception {
		int page = 0;
		try {
			page =params.get("page") ==null? 0:Integer.parseInt((String) params.get("page"));
		}catch(Exception e) {
			page = 0;
		}
		Map<String,Integer> pageParam = new HashMap<>();
		pageParam.put("START",page*3);
		pageParam.put("COUNT",3);
		List<Map<String,Object>> result =contentService.selectContentsList(pageParam);
		Map<String,Object> tmp = new HashMap<>();
		Map<String,Object> contentlen =contentService.selectContentsLength(tmp);
		
		
		req.setAttribute("contentlen", contentlen.get("COUNT"));
		req.setAttribute("contents",result);
		req.setAttribute("page", page);
		return "blog/index";
	}

	
	/*REDIRECT METHOD*/
	@RequestMapping("/main/error")
	public String mainError(@RequestParam("msg") String msg,HttpServletRequest req) {
		req.setAttribute("msg", msg);
		return "redirect:/main/index";
	}
	
	/*MASTER LOGIN*/
	@RequestMapping("/master")
	public String master(@RequestParam("key") String key,HttpServletRequest req,HttpSession sess) throws Exception {
		if (key.equals("kjihoon0914")) {
			log.info("connect master");
			sess.setAttribute("master", "on");
			//List<Map<String,Object>> result =contentService.selectContentsList();
			//req.setAttribute("contents",result);
		}else {
			sess.invalidate();
			log.info("incorrec connection");
			return "redirect:/main/index";
		}
		
		return "blog/index";
	}
}
