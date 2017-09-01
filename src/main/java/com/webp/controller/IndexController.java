package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webp.service.GetCommonInfoService;
import com.webp.service.model.service.common.ApiResponse;

@Controller
public class IndexController {

	@Autowired
	private GetCommonInfoService blogService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model, HttpSession session) {

		ApiResponse commonResponse = blogService.getCommonMenu("/", session);
		session.setAttribute("common", commonResponse);

        return "index";
	}


}
