package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.VisitorInfoPK;
/**
 * MODEL autogen macro
 * VisitorInfo
 * @auther KIM
*/
@Entity
@Table(name="VISITOR_INFO")
@IdClass(value = VisitorInfoPK.class)
public class VisitorInfo implements Serializable {
	public static final String TABLE = "VISITOR_INFO";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** 訪問ユーザID */
	@Column(name = "VISITOR_USER_ID")
	public String visitorUserId;

	/** 訪問時間 */
	@Id
	@Column(name = "VISIT_TIME")
	public Timestamp visitTime;

}