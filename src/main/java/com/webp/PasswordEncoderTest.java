package com.webp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	public static void main(String[] args)  {
		BCryptPasswordEncoder u = new BCryptPasswordEncoder();

		System.out.println( u.encode("1234"));

	}

}
