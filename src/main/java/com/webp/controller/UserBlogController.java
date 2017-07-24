package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webp.service.ViewUserBlogService;
import com.webp.service.model.service.common.ApiResponse;

@Controller
public class UserBlogController {

	@Autowired
	private ViewUserBlogService blogService;

	@RequestMapping(value = "/{blogUrl}", method = RequestMethod.GET)
	public String blogMain(@PathVariable("blogUrl") String blogUrl, Model model, HttpSession session) {

		ApiResponse response = blogService.getCommonMenu(blogUrl, session);

		if ("1".equals(response.noUser)) {
			return "pageNotFound";
		}

		model.addAttribute("common", response);

		return "user_main";
	}
}
