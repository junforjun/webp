package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.webp.service.GetCommonInfoService;
import com.webp.service.UserCheckService;
import com.webp.service.UserService;
import com.webp.service.model.userCreate.UserCreateRequest;
import com.webp.service.model.userCreate.UserCreateResponse;
import com.webp.util.Log;

@Controller
public class CreateRegUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private GetCommonInfoService blogService;

	@Autowired
	private UserCheckService userCheckService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		model.addAttribute("header", blogService.getCommonMenu("/user/registration", session));

		return "createRegUser";
	}

	@RequestMapping(value = "/user/step1", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String createUser(Model model, UserCreateRequest request, HttpSession session) {
		Log.vipLog(request.toString());

		UserCreateResponse res = userCheckService.checkStep1(request);

		return new Gson().toJson(res);
	}
}
