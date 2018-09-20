package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * MODEL autogen macro
 * VerificationEmail
 * @auther KIM
*/
@Entity
@Table(name="VERIFICATION_EMAIL")
public class VerificationEmail implements Serializable {
	public static final String TABLE = "VERIFICATION_EMAIL";

	/** 認証文字列 */
	@Column(name = "VERFI_STR")
	public String verfiStr;

	/** 認証時間 */
	@Column(name = "VERFI_TIME")
	public Timestamp verfiTime;

	/** E-Mail */
	@Column(name = "EMAIL")
	public String email;

}