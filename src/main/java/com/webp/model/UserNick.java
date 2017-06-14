package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.UserNickPK;
/**
 * MODEL autogen macro
 * UserNick
 * @auther KIM
*/
@Entity
@Table(name="USER_NICK")
@IdClass(value = UserNickPK.class)
public class UserNick implements Serializable {
	public static final String TABLE = "USER_NICK";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** ユーザニックネーム */
	@Column(name = "USER_NICK")
	public String userNick;

	/** 削除フラグ */
	@Column(name = "HIDDEN_FLAG")
	public String hiddenFlag;

	/** 生成ユーザ */
	@Column(name = "CREATED_USER")
	public String createdUser;

	/** 生成時間 */
	@Id
	@Column(name = "CREATED_TIME")
	public Timestamp createdTime;

}