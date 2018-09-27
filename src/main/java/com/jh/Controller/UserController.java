package com.jh.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.Service.UserService;

@Controller
public class UserController {

	//@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@RequestMapping(value = "/create/user" ,method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestParam Map<String,Object> params) throws Exception {
		JSONObject jo = new JSONObject();
		if (userService.insertUser(params)<1) {
			jo.put("msg", "false");
		}else {
			jo.put("msg", "true");
			//성공시 name 출력
			jo.put("id",params.get("name"));
		}
		return jo.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@RequestMapping(value = "/login/user" ,method = RequestMethod.POST)
	@ResponseBody
	public String loginUser(@RequestParam Map<String,Object> params,HttpSession sess) throws Exception {
		JSONObject jo = new JSONObject();
		Map<String,Object> map = userService.selectUserOne(params);
		if (map!=null) {
			jo.put("msg", "false");
		}else {
			jo.put("msg", "true");
			sess.setAttribute("id", params.get("id"));
		}		
		return jo.toJSONString();
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@RequestMapping(value = "/logout/user" ,method = RequestMethod.GET)
	@ResponseBody
	public String logoutUser(@RequestParam Map<String,Object> params,HttpSession sess) throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("msg", "true");
		sess.invalidate();
		return jo.toJSONString();
	}

		
	
}
