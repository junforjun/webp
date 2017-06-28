package com.webp.service.model.userBlog;

import java.util.ArrayList;
import java.util.List;

import com.webp.model.CategoryDetail;
import com.webp.model.MenuMaster;
import com.webp.service.model.service.common.ApiResponse;

public class UserBlogResponse extends ApiResponse {

	public String title;
	public String subTitle;
	public String noUser = "0";

	public List<MenuMaster> menuList = new ArrayList<>();
	public List<CategoryDetail> categoryList  = new ArrayList<>();
}
