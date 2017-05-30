package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model, HttpSession session) {

		model.addAttribute("aa", "say hellow");

        return "index";
	}


}
