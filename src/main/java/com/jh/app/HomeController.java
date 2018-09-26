package com.jh.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.Service.TestService;





/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private TestService testService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value="/testdb", produces = "application/json; charset=utf8")
	@ResponseBody
	public String body(@RequestParam(value="hi",defaultValue="hi") String body) throws Exception {
		logger.info(body);
		JSONObject  jo = new JSONObject();
		JSONArray jr = new JSONArray();
		Map<String,Object> param_map = new HashMap<>();
		/*param_map.put("id", "kjijihi0914");
		param_map.put("name", "jihoon12");
		List<Map<String, Object>> result = testService.selectTestList();
		testService.insertTest(param_map);
		
		param_map.put("id", "kjihoon0914");
		testService.deleteTest(param_map);
		jo.put("body", result.toString());
		*/
		List<Map<String,Object>> result = new ArrayList<>();
		result = testService.selectTestList();
		for (int i =0;i<result.size();i++)
		{
			jo.put("id", result.get(0).get("id"));
		}
		return jo.toJSONString();
	}
	
}
