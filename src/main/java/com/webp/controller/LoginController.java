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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.webp.config.AuthenticationToken;
import com.webp.model.Login;
import com.webp.model.UserInfo;
import com.webp.service.UserService;

@Controller

public class LoginController {

	@Autowired UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@RequestMapping(value="/login", method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String login(Login login, HttpSession session) {

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

        return new Gson().toJson(new AuthenticationToken(user.userId, userService.getAuthorities(user.userId), session.getId()));
	}


	@RequestMapping(value="/regUser", method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String regUser(Login user, HttpSession session) {

		if(user.getUsername().length() < 4) {
			return "ID length must input min to 4 char";
		}

		if(user.getPassword().length() < 4) {
			return "Password length must input min to 4 char";
		}

		if(user.getName().length() < 2) {
			return "Username length must input min to 2 char";
		}

		try {
			userService.createUser(user);
		} catch (Exception e) {
			return "Duplicate Member";
		}

		return "1";
	}

}
