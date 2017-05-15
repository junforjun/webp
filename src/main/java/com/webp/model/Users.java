package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * MODEL autogen macro
 * Users
 * @auther KIM
*/
@Entity
@Table(name="USERS")
public class Users implements Serializable {
	public static final String TABLE = "USERS";

	/** username */
	@Id
	@Column(name = "USERNAME")
	public String username;

	/** pwdhash */
	@Column(name = "PWDHASH")
	public String pwdhash;

	/** pwdalgorithm */
	@Column(name = "PWDALGORITHM")
	public String pwdalgorithm;

	/** useforwarding */
	@Column(name = "USEFORWARDING")
	public Integer useforwarding;

	/** forwarddestination */
	@Column(name = "FORWARDDESTINATION")
	public String forwarddestination;

	/** usealias */
	@Column(name = "USEALIAS")
	public Integer usealias;

	/** alias */
	@Column(name = "ALIAS")
	public String alias;

}