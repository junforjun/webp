package com.webp.service.impl;

import static com.webp.model.QCategoryDetail.*;
import static com.webp.model.QMenuMaster.*;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.UserInfo;
import com.webp.service.UserService;
import com.webp.service.ViewUserBlogService;
import com.webp.service.model.userBlog.UserBlogRequest;
import com.webp.service.model.userBlog.UserBlogResponse;

@Service
public class ViewUserBlogServiceImpl implements ViewUserBlogService{

	@Autowired
	private EntityManager em;

	@Autowired
	private UserService userService;

	@Override
	public UserBlogResponse getCommonMenu(UserBlogRequest userBlogRequest) {

		UserBlogResponse response = new UserBlogResponse();

		UserInfo user = userService.readUser(userBlogRequest.url);

		if (user == null) {
			response.noUser = "1";
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
