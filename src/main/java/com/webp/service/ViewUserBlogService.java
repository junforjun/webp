package com.webp.service;

import static com.webp.model.QCategoryDetail.*;
import static com.webp.model.QMenuMaster.*;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.UserInfo;
import com.webp.service.model.userBlog.UserBlogRequest;
import com.webp.service.model.userBlog.UserBlogResponse;

@Service
public class ViewUserBlogService {

	private static final Logger logger = LoggerFactory.getLogger(ViewUserBlogService.class);

	@Autowired
	private EntityManager em;

	@Autowired
	private UserService userService;

	public UserBlogResponse getCommonMenu(UserBlogRequest userBlogRequest) {

		UserBlogResponse response = new UserBlogResponse();

		UserInfo user = userService.readUserFromUrl(userBlogRequest.url);

		if (user == null) {
			response.noUser = "1";
			logger.debug("url not found : " + userBlogRequest.url);
			return response;
		}

		response.isMine = "1";
		response.isLogin = "1";

		response.title = user.blogTitle;
		response.subTitle = user.blogSubTitle;
		response.menuList = new JPAQuery(em).from(menuMaster).where(menuMaster.userId.eq(user.userId)).list(menuMaster);
		response.categoryList = new JPAQuery(em).from(categoryDetail).where(categoryDetail.userId.eq(user.userId)).list(categoryDetail);

		return response;
	}

}
