package com.webp.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.webp.model.UserDetail;
import com.webp.model.UserInfo;
import com.webp.service.model.userCreate.RegUserRequest;

@Service
public interface UserService extends UserDetailsService {

	Collection<GrantedAuthority> getAuthorities(String username);

	public UserInfo readUser(String username);

	public void createUser(RegUserRequest user);

	public int validateUser(UserInfo user);

	public void deleteUser(String username);

	public PasswordEncoder passwordEncoder();

	public UserDetail readUserFromUrl(String url) ;
	public UserDetail readUserFromId(String id) ;
}
