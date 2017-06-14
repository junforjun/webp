package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
/**
 * MODEL autogen macro
 * UserHobby
 * @auther KIM
*/
@Entity
@Table(name="USER_HOBBY")
public class UserHobby implements Serializable {
	public static final String TABLE = "USER_HOBBY";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** 趣味コード */
	@Column(name = "HOBBY_CODE")
	public String hobbyCode;

}