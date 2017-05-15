package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * MODEL autogen macro
 * UserInfo
 * @auther KIM
*/
@Entity
@Table(name="USER_INFO")
public class UserInfo implements Serializable {
	public static final String TABLE = "USER_INFO";

	/** ID(Email) */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** PASS */
	@Column(name = "USER_PASS")
	public String userPass;

	/** 生年月日 */
	@Column(name = "BIRTH_DAY")
	public String birthDay;

	/** 性別 */
	@Column(name = "SEX")
	public Integer sex;

	/** 住所1 */
	@Column(name = "LOCATION")
	public String location;

	/** ログイン時刻 */
	@Column(name = "LAST_LOGIN", nullable = false)
	public Timestamp lastLogin;

	/** ログインIP */
	@Column(name = "LOGIN_IP", nullable = false)
	public String loginIp;

}