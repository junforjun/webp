package com.webp.service.impl;

import static com.webp.model.QUserDetail.*;
import static com.webp.model.QUserInfo.*;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.CategoryDetail;
import com.webp.model.Login;
import com.webp.model.QUserAuthentication;
import com.webp.model.UserAuthentication;
import com.webp.model.UserDetail;
import com.webp.model.UserInfo;
import com.webp.model.db.CategoryDetail_DB;
import com.webp.model.db.UserAuthentication_DB;
import com.webp.model.db.UserDetail_DB;
import com.webp.model.db.UserInfo_DB;
import com.webp.service.UserService;
import com.webp.service.model.userCreate.UserCreateRequest;
import com.webp.util.StrUtil;
import com.webp.util.TimeUtil;

@Service
public class UserServiceImpl implements UserService {

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private EntityManager em;

	@Autowired
	private UserInfo_DB userInfoDb;

	@Autowired
	private UserDetail_DB userDetailDB;

	@Autowired
	private CategoryDetail_DB categoryDetail_DB;

	@Autowired
	private UserAuthentication_DB userAuthenticationDb;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		UserInfo user = readUser(username);

		Login userDetails = new Login();
		userDetails.setUsername(username);
		userDetails.setPassword(user.userPass);

		System.out.println(user.userPass);

		try {
			System.out.println(StrUtil.digestString(user.userPass));
		} catch (Exception e) {
			e.printStackTrace();
		}

		userDetails.setAccountNonExpired(true);
		userDetails.setAccountNonLocked(true);
		userDetails.setCredentialsNonExpired(true);
		userDetails.setEnabled(true);

		userDetails.setAuthorities(getAuthorities(username));

		return userDetails;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		JPQLQuery  query = new JPAQuery(em);

		QUserAuthentication userAuth = QUserAuthentication.userAuthentication;
		UserAuthentication user = query.from(userAuth).where(userAuth.userId.eq(username))
				.uniqueResult(userAuth);

		HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

//		authorities.add(new SimpleGrantedAuthority(user.userAuth));

        return authorities;
	}

	@Override
	public UserInfo readUser(String username) {
		return new JPAQuery(em).from(userInfo).where(userInfo.userId.eq(username))
				.uniqueResult(userInfo);
	}
	@Override
	public UserDetail readUserFromUrl(String url) {
		UserDetail userdetail = new JPAQuery(em).from(userDetail)
									.where(userDetail.urlId.eq(url))
									.singleResult(userDetail);

		if(userdetail == null || StrUtil.isEmpty(userdetail.userId)) {
			return null;
		}

		return userdetail;
	}
	@Override
	public UserDetail readUserFromId(String id) {
		UserDetail userdetail = new JPAQuery(em).from(userDetail)
									.where(userDetail.userId.eq(id))
									.singleResult(userDetail);

		if(userdetail == null || StrUtil.isEmpty(userdetail.userId)) {
			return null;
		}

		return userdetail;
	}

	@Override
	public void deleteUser(String username) {
	}

	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

	@Override
	@Transactional
	public void createUser(UserCreateRequest request) {
		UserInfo user = new UserInfo();
		user.userId = request.userId;
		user.firstName = request.firstName;
		user.lastName = request.lastName;
		user.sex = request.sex;
		user.userPass = passwordEncoder().encode(request.userPass);
		user.isVerificationed = "1";
		user.createdTime = TimeUtil.getCurrentTimeStamp();
		user.createdUser = request.userId;
		userInfoDb.save(user);

		UserDetail userDetail = new UserDetail();
		userDetail.userId = request.userId;
		userDetail.userNick = request.userNick;
		userDetail.urlId = request.urlId;
		userDetail.blogTitle = "まだ設定されていません。";
		userDetail.blogSubTitle = "";
		userDetail.infoOpenLevel = "1";
		userDetail.createdTime = TimeUtil.getCurrentTimeStamp();
		userDetail.createdUser = request.userId;
		userDetailDB.save(userDetail);

		// TODO メニュー設定必要
//		MenuMaster menu = new MenuMaster();

		CategoryDetail category = new CategoryDetail();

		category.catecoryName = "基本カテゴリ";
		category.categoryCode = "0";
		category.userId = user.userId;
		category.topCategoryFlag = "1";
		categoryDetail_DB.save(category);
	}

	@Override
	public int validateUser(UserInfo user) {



		return 0;
	}
}
