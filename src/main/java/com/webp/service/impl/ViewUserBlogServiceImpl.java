package com.webp.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//		 new JPAQuery(em).from(arg)


		return null;
	}

}
