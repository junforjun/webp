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
import com.webp.service.model.userCreate.UserCreateRequest;

@Controller
public class CreateRegUser {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {

		model.addAttribute("aa", "say hellow");

		return "createRegUser";
	}

	@Autowired
	UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@RequestMapping(value = "/regUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody

	public String createUser(UserCreateRequest userCreateRequest, HttpSession session) {

		UserInfo userInfo = new UserInfo();
		userInfo.firstName = userCreateRequest.userfirstname;
		userInfo.lastName = userCreateRequest.userlastname;
		//userInfo. = userCreateRequest.userEmail;
		userInfo.userId = userCreateRequest.userID;
		userInfo.userPass = userCreateRequest.userPassword;
		userInfo.sex = userCreateRequest.userSex;

			try {
				userService.createUser(userInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return userInfo.userId+" 안녕?";

	}
}
