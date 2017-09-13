package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webp.service.GetCommonInfoService;
import com.webp.service.WriteUserBlogService;
import com.webp.service.model.service.common.ApiResponse;
import com.webp.service.model.userBlog.BlogWriteRequest;
import com.webp.util.Log;

@Controller
public class WriteConmtroller {
	@Autowired
	private GetCommonInfoService blogService;

	@Autowired
	private WriteUserBlogService writeUserBlogService;

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writePostPage(Model model, HttpSession session) {


		ApiResponse response = blogService.getCommonMenu("write", session);

		if ("1".equals(response.noUser)) {
			return "pageNotFound";
		}

		model.addAttribute("header", response);

		return "write";
	}

	@RequestMapping(value = "/writePost", method = RequestMethod.POST)
	@ResponseBody
	public String writePost(BlogWriteRequest request, HttpSession session) {

		Log.debug(request.toString());

		String result = writeUserBlogService.writeBlogPost(request, session);
		return session.getAttribute("url") + result;
	}
}
