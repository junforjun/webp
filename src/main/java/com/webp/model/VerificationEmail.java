package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Id
	@Column(name = "VERFIY_STR")
	public String verfiyStr;

	/** 認証時間 */
	@Column(name = "VERFIY_TIME")
	public Timestamp verfiyTime;

	/** E-Mail */
	@Column(name = "EMAIL")
	public String email;

	/** Password */
	@Column(name = "PASS")
	public String pass;

	/** 認証確認 */
	@Column(name = "IS_VERIFICATIONED")
	public String isVerificationed;

}