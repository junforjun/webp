/**
 *
 */
package com.webp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jiun
 *
 */
@Controller
public class MyCalendarController {

	@RequestMapping(value = "/{blogUrl}//myCalendar", method = RequestMethod.GET)
	public String calendar(Model model, HttpSession session, HttpServletRequest request) {

		return "MyCalendar";
	}

}
