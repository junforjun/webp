package com.webp.service.model.userBlog;

import java.util.List;

import com.webp.model.CategoryDetail;
import com.webp.model.MenuMaster;
import com.webp.service.model.service.common.ApiResponse;

public class UserBlogResponse extends ApiResponse {

	public String title;
	public String subTitle;

	public List<MenuMaster> menuList;
	public List<CategoryDetail> categoryList;
}
