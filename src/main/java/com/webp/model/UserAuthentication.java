package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * MODEL autogen macro
 * UserAuthentication
 * @auther KIM
*/
@Entity
@Table(name="USER_AUTHENTICATION")
public class UserAuthentication implements Serializable {
	public static final String TABLE = "USER_AUTHENTICATION";

	/** ID(Email) */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** 権限 */
	@Column(name = "USER_AUTH")
	public String userAuth;

}