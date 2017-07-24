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
import com.webp.service.model.userBlog.UserBlogRequest;

@Controller
public class WriteConmtroller {
	@Autowired
	private ViewUserBlogService blogService;

	@RequestMapping(value = "/{blogUrl}/write", method = RequestMethod.GET)
	public String writePost(UserBlogRequest userBlogRequest, Model model, @PathVariable("blogUrl") String blogUrl, HttpSession session) {

		ApiResponse response = blogService.getCommonMenu(blogUrl, session);

		if ("1".equals(response.noUser)) {
			return "pageNotFound";
		}

		model.addAttribute("common", response);

		return "write";
	}
}
