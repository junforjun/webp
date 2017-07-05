package com.webp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webp.service.ViewUserBlogService;
import com.webp.service.model.userBlog.UserBlogRequest;
import com.webp.service.model.userBlog.UserBlogResponse;

@Controller
public class UserBlogController {

	@Autowired
	private ViewUserBlogService blogService;

	@RequestMapping(value = "/{blogUrl}", method = RequestMethod.GET)
	public String blogMain(UserBlogRequest userBlogRequest, Model model, @PathVariable("blogUrl") String blogUrl) {

		userBlogRequest.url = blogUrl;

		UserBlogResponse blogContents = blogService.getCommonMenu(userBlogRequest);
		blogContents.url = blogUrl;

		model.addAttribute("blogContents", blogContents);
		model.addAttribute("test", "test");

		if ("1".equals(blogContents.noUser)) {
			return "pageNotFound";
		}

		return "user_main";

	}

}
