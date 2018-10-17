package com.jh.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.Service.TestService;

@Controller
public class TestController {

	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/bank/test", produces="text/plain;charset=UTF-8")
	@ResponseBody
	@Transactional
	public String bank() throws Exception{
		
		Map<String,Object> map = new HashMap<>();
		map.put("NAME", "JIHOON2");
		map.put("ACCOUNT", "110339");
		map.put("BALANCE", 0);
		testService.insertTest(map);
		
		if ("".equals("")) {
			Exception e = new Exception(); 
			throw e;
			
		}
		
		map.put("BALANCE",3000);
		testService.updateTest(map);
		
		return "success"; 
	}
}
