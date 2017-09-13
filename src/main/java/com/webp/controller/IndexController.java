package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webp.service.GetCommonInfoService;

@Controller
public class IndexController {

	@Autowired
	private GetCommonInfoService blogService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		model.addAttribute("header", blogService.getCommonMenu("/", session));
        return "index";
	}
}
