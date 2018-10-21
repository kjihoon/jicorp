package com.jh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	
	/*@RequestMapping("/echo")
	public String echo() {
		return "/manager/echo";
	}*/
	@RequestMapping("/kwakaotalk")
	public String chat() {
		return "/mobile/chat";
	}
	
}
