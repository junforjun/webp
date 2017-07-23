package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webp.model.UserInfo;
import com.webp.service.UserService;

@Controller
public class CreateRegUserController {

	@Autowired
	UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		return "createRegUser";
	}

	@RequestMapping(value = "/user/regUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String createUser(UserInfo userInfo, HttpSession session) {

		System.out.println(userInfo.toString());
		userService.createUser(userInfo);

		return "1";
	}
}
