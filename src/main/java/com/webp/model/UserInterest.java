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
 * UserInterest
 * @auther KIM
*/
@Entity
@Table(name="USER_INTEREST")
public class UserInterest implements Serializable {
	public static final String TABLE = "USER_INTEREST";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** 興味コード */
	@Column(name = "INTEREST_CODE")
	public String interestCode;

}