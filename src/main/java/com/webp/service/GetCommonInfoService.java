package com.webp.service;

import static com.webp.model.QCategoryDetail.*;
import static com.webp.model.QMenuMaster.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.UserDetail;
import com.webp.service.model.service.common.ApiResponse;
import com.webp.util.Log;

@Service
public class GetCommonInfoService {

	private static final Logger logger = LoggerFactory.getLogger(GetCommonInfoService.class);

	@Autowired
	private EntityManager em;

	@Autowired
	private UserService userService;

	public ApiResponse getCommonMenu(HttpSession session) {

		String url = (String) session.getAttribute("url");
		return getCommonMenu(url, session);
	}

	public ApiResponse getCommonMenu(String url, HttpSession session) {
		ApiResponse response = new ApiResponse();
		UserDetail user = new UserDetail();

		Log.debug("Requested Page : " + url);

		SecurityContext con = (SecurityContext)session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);

		if(con != null) {
			System.out.println(con.getAuthentication().getName() + ": Logined");
			user = userService.readUserFromId(con.getAuthentication().getName());
			response.isLogin = "1";

			if(user.userId.equals(con.getAuthentication().getName())) {
				response.isMine = "1";
			}
		} else {
			user = userService.readUserFromUrl(url);
			if (user == null) {
				response.noUser = "1";
				logger.debug("url not found : " + url);
				return response;
			}
		}

		response.url = url;
		response.title = user.blogTitle;
		response.subTitle = user.blogSubTitle;
		response.menuList = new JPAQuery(em).from(menuMaster).where(menuMaster.userId.eq(user.userId)).list(menuMaster);
		response.categoryList = new JPAQuery(em).from(categoryDetail).where(categoryDetail.userId.eq(user.userId)).list(categoryDetail);

		return response;
	}
}
