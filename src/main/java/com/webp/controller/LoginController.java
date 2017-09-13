package com.webp.controller;

import javax.servlet.http.HttpServletRequest;
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
import com.webp.model.UserDetail;
import com.webp.model.UserInfo;
import com.webp.model.UserLogin;
import com.webp.model.db.UserLogin_DB;
import com.webp.service.GetCommonInfoService;
import com.webp.service.UserService;
import com.webp.util.DateUtil;
import com.webp.util.StrUtil;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private GetCommonInfoService blogService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserLogin_DB userLoginDB;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, HttpSession session, HttpServletRequest request) {

		String referrer = request.getHeader("Referer");
		request.getSession().setAttribute("prevPage", referrer);
		model.addAttribute("header", blogService.getCommonMenu(session));

		return "login";
	}

	@RequestMapping(value="/auth", method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String auth(Model model, Login login, HttpSession session) {

		UserInfo user = null;
		UserDetail userDetail = null;
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
			          SecurityContextHolder.getContext());

			user = userService.readUser(login.getUsername());
			userDetail = userService.readUserFromId(login.getUsername());
			session.setAttribute(user.userId, user);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return null;
		}

		UserLogin userLogin = new UserLogin();
		userLogin.userId = user.userId;
		userLogin.loginTime = DateUtil.getCurrentTimeStamp();
		userLoginDB.save(userLogin);


		model.addAttribute("AuthenticationToken", new Gson().toJson(
				new AuthenticationToken(user.userId, userService.getAuthorities(user.userId), session.getId())));

		session.setAttribute("url", userDetail.urlId);

		String referrer = (String)session.getAttribute("prevPage");


		System.out.println("★★★★★★★" + referrer);

        return StrUtil.isEmpty(referrer) ? userDetail.urlId : referrer;
	}

}
