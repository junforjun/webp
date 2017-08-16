package com.webp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webp.model.PostDetail;
import com.webp.service.GetBlogPostService;
import com.webp.service.GetCommonInfoService;
import com.webp.service.model.service.common.ApiResponse;
import com.webp.util.CollectionUtil;

@Controller
public class UserBlogController {

	@Autowired
	private GetCommonInfoService blogService;

	@Autowired
	private GetBlogPostService blogPostService;

	@RequestMapping(value = "/{blogUrl}", method = RequestMethod.GET)
	public String blogMain(@PathVariable("blogUrl") String blogUrl, Model model, HttpSession session) {

		ApiResponse commonResponse = blogService.getCommonMenu(blogUrl, session);

		if ("1".equals(commonResponse.noUser)) {
			return "pageNotFound";
		}

		model.addAttribute("common", commonResponse);

		return "user_main";
	}

	@RequestMapping(value = "/{blogUrl}/{category}", method = RequestMethod.GET)
	public String getPostCategory(@PathVariable("blogUrl") String blogUrl
							, @PathVariable("category") String categoryCode
							, Model model, HttpSession session) {

		ApiResponse commonResponse = blogService.getCommonMenu(blogUrl, session);

		if ("1".equals(commonResponse.noUser)) {
			return "pageNotFound";
		}
		model.addAttribute("common", commonResponse);

		List<PostDetail> postResponse = blogPostService.getPost(categoryCode, null);

		if(CollectionUtil.isNull(postResponse)) {
			return "pageNotFound";
		}

		model.addAttribute("postList", postResponse);

		return "user_post";
	}

	@RequestMapping(value = "/{blogUrl}/{category}/{postNo}", method = RequestMethod.GET)
	public String getPostOne(@PathVariable("blogUrl") String blogUrl
							, @PathVariable("category") String categoryCode
							, @PathVariable("postNo") String postNo
							, Model model, HttpSession session) {

		ApiResponse commonResponse = blogService.getCommonMenu(blogUrl, session);

		if ("1".equals(commonResponse.noUser)) {
			return "pageNotFound";
		}
		model.addAttribute("common", commonResponse);

		List<PostDetail> postResponse = blogPostService.getPost(categoryCode, postNo);

		if(CollectionUtil.isNull(postResponse)) {
			return "pageNotFound";
		}

		model.addAttribute("postList", postResponse);

		return "user_post";
	}


}
