package com.dh.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/toLogin")
	public String jumpIndex() {
		return "login";
	}

	@RequestMapping("/error")
	public String errorUser() {
		return "error";
	}

	// 实现用户登录
	@RequestMapping(value = "/login")
	public String Login(String username, String password, Model model) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		String error = null;

		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "用户名/密码错误";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (AuthenticationException e) {
			// 其他错误，比如锁定，如果想单独处理请单独catch处理
			error = "其他错误：" + e.getMessage();
		}
		System.out.println("error:" + error);

		if (error != null) {// 出错了，返回登录页面
			model.addAttribute("error", error);
			return "login";
		} else {// 登录成功

		}
		// 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接
		return "success";
	}

}
