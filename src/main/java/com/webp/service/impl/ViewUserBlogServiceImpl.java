package com.webp.service.impl;

import static com.webp.model.QCategoryDetail.*;
import static com.webp.model.QMenuMaster.*;
import static com.webp.model.QUserInfo.*;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.UserInfo;
import com.webp.service.ViewUserBlogService;
import com.webp.service.model.userBlog.UserBlogRequest;
import com.webp.service.model.userBlog.UserBlogResponse;

@Service
public class ViewUserBlogServiceImpl implements ViewUserBlogService{

	@Autowired
	private EntityManager em;

	@Override
	public UserBlogResponse searchBlogContents(UserBlogRequest userBlogRequest) {

		UserBlogResponse response = new UserBlogResponse();

		String url = userBlogRequest.url;
		UserInfo user = new JPAQuery(em).from(userInfo).where(userInfo.urlId.eq(url)).uniqueResult(userInfo);

		if (user == null) {
			return null;
		}

		response.title = user.blogTitle;
		response.subTitle = user.blogSubTitle;
		response.menu = new JPAQuery(em).from(menuMaster).where(menuMaster.userId.eq(user.userId)).list(menuMaster);
		response.category = new JPAQuery(em).from(categoryDetail).where(categoryDetail.userId.eq(user.userId)).list(categoryDetail);

		return response;
	}

}
