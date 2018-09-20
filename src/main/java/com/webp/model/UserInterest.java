package com.webp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.webp.model.pk.UserInterestPK;
/**
 * MODEL autogen macro
 * UserInterest
 * @auther KIM
*/
@Entity
@Table(name="USER_INTEREST")
@IdClass(value = UserInterestPK.class)
public class UserInterest implements Serializable {
	public static final String TABLE = "USER_INTEREST";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** 興味コード */
	@Id
	@Column(name = "INTEREST_CODE")
	public String interestCode;

}