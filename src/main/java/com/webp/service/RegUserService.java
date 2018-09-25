package com.webp.service;
import static com.webp.model.QVerificationEmail.*;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.VerificationEmail;
import com.webp.model.db.VerificationEmail_DB;
import com.webp.service.model.userCreate.RegUserRequest;
import com.webp.util.DateUtil;
import com.webp.util.Log;
import com.webp.util.MailUtil;
import com.webp.util.StrUtil;

@Service
public class RegUserService {

	@Autowired
	private EntityManager em;

	@Autowired
	private VerificationEmail_DB verfi;

	@Autowired
	private UserService user;

	/**
	 * 認証文字列をＤＢに登録
	 * @param request.getEmail()
	 */
	@Transactional
	public void regVerification(RegUserRequest request) {

		Timestamp now = DateUtil.getCurrentTimeStamp();

		//認証を登録する前にいらなくなった認証（５分が過ぎたもの）を削除する。
		long delCnt = new JPADeleteClause(em, verificationEmail)
				.where(verificationEmail.verfiyTime.before(DateUtil.addMin(now, -5)))
				.execute();

		Log.debug("認証メール：" + delCnt  + "件削除しました。");

		VerificationEmail model =  new VerificationEmail();
		String verfiyStr = StrUtil.getRandomPassword(255);
		model.verfiyStr = verfiyStr;
		model.email = request.getEmail();
		model.verfiyTime = now;
		model.isVerificationed = "0";
		model.pass = user.passwordEncoder().encode(request.getPass());
		verfi.save(model);

		MailUtil.sendVerfiyMail(request.getEmail(), verfiyStr);
	}

	/**
	 * 認証文字列が存在する場合（５分以内）
	 * @param verfiyStr
	 * @return
	 */
	public VerificationEmail getVerfyInfoByStr(String verfiyStr) {
		Timestamp now = DateUtil.getCurrentTimeStamp();
		return new JPAQuery(em).from(verificationEmail)
						.where(verificationEmail.verfiyStr.eq(verfiyStr)
								.and(verificationEmail.verfiyTime.goe(DateUtil.addMin(now, 5)))
								.and(verificationEmail.isVerificationed.eq("0")))
						.singleResult(verificationEmail);
	}

	/**
	 * 認証文字列が存在する場合（５分以内）
	 * @param verfiyStr
	 * @return
	 */
	public VerificationEmail getVerfyInfoByEmail(String email) {
		return new JPAQuery(em).from(verificationEmail)
						.where(verificationEmail.email.eq(email)
								.and(verificationEmail.isVerificationed.eq("0")))
						.singleResult(verificationEmail);
	}

	/**
	 * 認証ＯＫの場合認証フラッグを設定
	 * @param model
	 */
	@Transactional
	public void changeFlagForSuccess(VerificationEmail model, String flag) {
		model.isVerificationed = "1";
		verfi.save(model);
	}
}
