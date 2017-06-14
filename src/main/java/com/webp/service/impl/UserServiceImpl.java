package com.webp.service.impl;

import static com.webp.model.QUserInfo.*;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.Login;
import com.webp.model.QUserAuthentication;
import com.webp.model.UserAuthentication;
import com.webp.model.UserInfo;
import com.webp.model.db.UserAuthentication_DB;
import com.webp.model.db.UserInfo_DB;
import com.webp.service.UserService;
import com.webp.util.StrUt;

@Service
public class UserServiceImpl implements UserService {

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private EntityManager em;

	@Autowired
	private UserInfo_DB userInfoDb;

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
			System.out.println(StrUt.digestString(user.userPass));
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
	public void deleteUser(String username) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

	@Override
	public void createUser(UserInfo user) throws Exception {
		UserInfo userInfo = new UserInfo();

		userInfo.userId = user.userId;
		userInfo.userPass = passwordEncoder.encode(user.userPass);

		userInfoDb.save(userInfo);

		UserAuthentication ua = new UserAuthentication();
		ua.userId = user.userId;
//		ua.userAuth = "1";

		userAuthenticationDb.save(ua);

//		Users mailAccount = new Users();
//		mailAccount.username = user.getUsername();
//		mailAccount.pwdhash = StrUt.digestString(userInfo.userPass);
//		mailAccount.pwdalgorithm = "SHA";
//		mailAccount.useforwarding = 0;
//		mailAccount.usealias = 0;
//
//		UsersDb.save(mailAccount);

	}


}
