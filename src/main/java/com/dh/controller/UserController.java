package com.dh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/home")
	public String jumpHome() {
		return "home";
	}

	@RequestMapping("/check")
	public String checkUser() {
		return "check";
	}



	@RequestMapping("/ceshi")
	@ResponseBody
	public String ceshi() {
		return "nihao";
	}


}
