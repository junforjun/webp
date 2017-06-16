package com.webp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webp.service.ViewUserBlogService;
import com.webp.service.model.userBlog.UserBlogRequest;

@Controller
public class UserBlogController {

	@Autowired
	private ViewUserBlogService blogService;

	@RequestMapping(value = "/{blogUrl}", method = RequestMethod.GET)
	public String blogMain(UserBlogRequest userBlogRequest, Model model, @PathVariable("url") String blogUrl) {

		System.out.println(userBlogRequest.name);

		model.addAttribute(blogService.searchBlogContents(userBlogRequest));

		return "user_main";

	}

}
