package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.webp.config.AuthenticationToken;
import com.webp.model.Login;
import com.webp.model.UserInfo;
import com.webp.model.UserLogin;
import com.webp.model.db.UserLogin_DB;
import com.webp.service.UserService;
import com.webp.util.DateUtil;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserLogin_DB userLogin;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		return "login";
	}

	@RequestMapping(value="/auth", method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String auth(Model model, Login login, HttpSession session) {

		UserInfo user = null;
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
			          SecurityContextHolder.getContext());

			user = userService.readUser(login.getUsername());
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return null;
		}

		UserLogin userLogin = new UserLogin();

		userLogin.userId = user.userId;
		userLogin.loginTime = DateUtil.getCurrentTimeStamp();



		model.addAttribute("AuthenticationToken", new Gson().toJson(
				new AuthenticationToken(user.userId, userService.getAuthorities(user.userId), session.getId())));

        return user.urlId;
	}
}
