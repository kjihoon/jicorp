package com.jh.Controller;

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

@Controller
public class MainController {
	@Autowired
	ContentsService contentService;
	
	
	Logger log = Logger.getLogger(this.getClass());
	
	
	@RequestMapping("/main/index")
	public String mainIndex(HttpServletRequest req) throws Exception {
		List<Map<String,Object>> result =contentService.selectContentsList();
		req.setAttribute("contents",result);
		
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
			List<Map<String,Object>> result =contentService.selectContentsList();
			req.setAttribute("contents",result);
		}else {
			sess.invalidate();
			return "redirect:/main/index";
		}
		
		return "blog/index";
	}
}
