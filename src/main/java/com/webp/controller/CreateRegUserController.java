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
import com.webp.service.RegUserService;
import com.webp.service.UserCheckService;
import com.webp.service.UserService;
import com.webp.service.model.userCreate.RegUserRequest;
import com.webp.service.model.userCreate.RegUserResponse;
import com.webp.util.Log;

@Controller
public class CreateRegUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private GetCommonInfoService blogService;

	@Autowired
	private RegUserService regUserService;

	@Autowired
	private UserCheckService userCheckService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String createRegUser(Model model, HttpSession session) {
		model.addAttribute("header", blogService.getCommonMenu("/user/registration", session));
		if(session.getAttribute("email") != null) {
			session.removeAttribute("email");
			session.removeAttribute("pass");
			return "page_expired";
		}
		return "createRegUser";
	}

	@RequestMapping(value = "/user/step1/id", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String checkId(Model model, RegUserRequest request, HttpSession session) {
		RegUserResponse res = userCheckService.checkId(request);
		return new Gson().toJson(res);
	}

	@RequestMapping(value = "/user/step1/pass", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String checkPass(Model model, RegUserRequest request, HttpSession session) {
		RegUserResponse res = userCheckService.checkPass(request);
		return new Gson().toJson(res);
	}

	@RequestMapping(value = "/user/registration2", method = RequestMethod.POST)
	public String createRegUser2(Model model, RegUserRequest request, HttpSession session) {
		model.addAttribute("header", blogService.getCommonMenu("/user/registration2", session));

		if(request.email == null) {
			return  "page_expired";
		}

		// メール認証用文字列をＤＢに登録する。
		regUserService.regVerification(request.getEmail());

		Log.debug(request.email + " / " + request.pass );
		session.setAttribute("email", request.getEmail());
		session.setAttribute("pass", request.getPass());

		return "createRegUser2";
	}
}
