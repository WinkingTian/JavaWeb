package com.javaweb.app.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.javaweb.web.rbac.service.RoleService;

@Controller
@RequestMapping(value="/app")
public class APPTestController {
	
	@Autowired
	private RoleService roleService;
	
	//GET方式测试
	@GetMapping(value="/testGet",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String testGet(HttpServletRequest request,
						  HttpServletResponse response){
		long startTime = System.currentTimeMillis();
		JSONObject jo1 = new JSONObject();
		jo1.put("a1", 1);
		jo1.put("b1", 2);
		jo1.put("c1", 3);
		JSONObject jo2 = new JSONObject();
		jo2.put("a2", 4);
		jo2.put("b2", 5);
		jo2.put("c2", 6);
		JSONObject jo3 = new JSONObject();
		jo3.put("a3", 7);
		jo3.put("b3", 8);
		jo3.put("c3", 9);
		JSONArray ja = new JSONArray();
		ja.add(jo1);
		ja.add(jo2);
		ja.add(jo3);
		JSONObject out = new JSONObject();
		out.put("result", ja.toString());
		out.put("time",System.currentTimeMillis()-startTime);
		return out.toString();
	}
	
	//GET方式测试
	@GetMapping(value="/testGet2",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String testGet2(HttpServletRequest request,
						  HttpServletResponse response){
		JSONObject out = new JSONObject();
		out.put("data",roleService.getAllRoles());
		return out.toString();
	}
	
	//GET方式测试
	@GetMapping(value="/testGet3",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String testGet3(HttpServletRequest request,
						  HttpServletResponse response){
		JSONObject out = new JSONObject();
		out.put("data",roleService.getAllRoles());
		return out.toString();
	}
	
	//POST方式测试
	@PostMapping(value="/testPost",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String testPost(HttpServletRequest request,
						   HttpServletResponse response,
						   @RequestBody JsonNode jsonNode){
		long startTime = System.currentTimeMillis();
		JSONObject jo = new JSONObject();
		jo.put("result", jsonNode.toString());
		jo.put("time",System.currentTimeMillis()-startTime);
		return jo.toString();
	}

}
