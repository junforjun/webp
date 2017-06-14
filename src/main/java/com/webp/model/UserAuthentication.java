package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.UserAuthenticationPK;
/**
 * MODEL autogen macro
 * UserAuthentication
 * @auther KIM
*/
@Entity
@Table(name="USER_AUTHENTICATION")
@IdClass(value = UserAuthenticationPK.class)
public class UserAuthentication implements Serializable {
	public static final String TABLE = "USER_AUTHENTICATION";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** ユーザレベル */
	@Id
	@Column(name = "USER_LEVEL")
	public String userLevel;

	/** 生成ユーザID */
	@Column(name = "CREATED_USER", nullable = false)
	public String createdUser;

	/** 生成時間 */
	@Column(name = "CREATED_TIME", nullable = false)
	public Timestamp createdTime;

	/** 修正ユーザID */
	@Column(name = "EDITED_USER")
	public String editedUser;

	/** 修正時間 */
	@Column(name = "EDITED_TIME")
	public Timestamp editedTime;

}