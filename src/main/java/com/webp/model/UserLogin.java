package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.UserLoginPK;
/**
 * MODEL autogen macro
 * UserLogin
 * @auther KIM
*/
@Entity
@Table(name="USER_LOGIN")
@IdClass(value = UserLoginPK.class)
public class UserLogin implements Serializable {
	public static final String TABLE = "USER_LOGIN";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** ログイン時間 */
	@Id
	@Column(name = "LOGIN_TIME")
	public Timestamp loginTime;

	/** ログインカウント */
	@Column(name = "LOGIN_COUNT")
	public Integer loginCount;

	/** ログインIP */
	@Column(name = "LOGIN_IP")
	public Timestamp loginIp;

}