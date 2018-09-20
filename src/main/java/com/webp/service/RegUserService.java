package com.webp.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webp.model.VerificationEmail;
import com.webp.model.db.VerificationEmail_DB;
import com.webp.util.DateUtil;
import com.webp.util.MailUtil;
import com.webp.util.StrUtil;

@Service
public class RegUserService {

	@Autowired
	private EntityManager em;

	@Autowired
	private VerificationEmail_DB verfi;

	@Transactional
	public void regVerification(String email) {
		VerificationEmail model =  new VerificationEmail();
		String verfiyStr = StrUtil.getRandomPassword(255);
		model.verfiStr = verfiyStr;
		model.email = email;
		model.verfiTime = DateUtil.getCurrentTimeStamp();
		verfi.save(model);

		MailUtil.sendVerfiyMail(email, verfiyStr);
	}

}
