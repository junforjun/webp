package com.webp.service.model.service.common;

import java.util.ArrayList;
import java.util.List;

import com.webp.model.CategoryDetail;
import com.webp.model.MenuMaster;

public class ApiResponse {

	// リクエストしたブログが自分のものかのフラグ
	public String isMine = "0";

	// ログインフラグ
	public String isLogin = "0";

	public String url;

	public String title;
	public String subTitle;
	public String noUser = "0";

	public List<MenuMaster> menuList = new ArrayList<>();
	public List<CategoryDetail> categoryList  = new ArrayList<>();

}
