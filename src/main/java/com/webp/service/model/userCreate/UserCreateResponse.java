package com.webp.service.model.userCreate;

import java.util.List;

import com.webp.model.CategoryDetail;
import com.webp.model.MenuMaster;
import com.webp.service.model.service.common.ApiResponse;

public class UserCreateResponse extends ApiResponse {

	public String title;
	public String subTitle;

	public List<MenuMaster> menu;
	public List<CategoryDetail> category;
}
