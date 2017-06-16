package com.webp.service;

import com.webp.service.model.userBlog.UserBlogRequest;
import com.webp.service.model.userBlog.UserBlogResponse;

public interface ViewUserBlogService {
	public UserBlogResponse searchBlogContents(UserBlogRequest userBlogRequest);

}
