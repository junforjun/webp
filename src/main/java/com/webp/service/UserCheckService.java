package com.webp.service;

import static com.webp.model.QUserInfo.*;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.service.model.userCreate.UserCreateRequest;
import com.webp.service.model.userCreate.UserCreateResponse;
import com.webp.util.Log;
import com.webp.util.StrUtil;

@Service
public class UserCheckService {
	private static final Logger logger = LoggerFactory.getLogger(GetCommonInfoService.class);

	@Autowired
	private EntityManager em;

	public UserCreateResponse checkStep1(UserCreateRequest request) {

		UserCreateResponse res = new UserCreateResponse();

		String id = request.getId();

		if(id.isEmpty()) {
			res.message = "Please input your E-MAIL";
		} else if(!StrUtil.isEmail(id)) {
			res.message = "Please input collect E-MAIL";
		} else {
			long isExistId = new JPAQuery(em).from(userInfo).where(userInfo.userId.eq(id)).count();

			if(isExistId > 0) {
				res.message = "Already exist E-MAIL";
			}
		}

		Log.debug(res.message);

		return res;
	}
}
