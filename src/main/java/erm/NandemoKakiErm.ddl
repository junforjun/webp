/**********************************/
/* «Æ?«Ö«ëÙ£: user_master */
/**********************************/
CREATE TABLE USER_MASTER(
		USER_ID VARCHAR(2147483647) NOT NULL,
		PASS BYTEA,
		BIRTH_DAY VARCHAR(8),
		SEX VARCHAR(1),
		LOCATION VARCHAR(2147483647),
		LAST_LOGIN TIMESTAMP NOT NULL,
		LOGIN_IP VARCHAR(2147483647),
		LAST_UPDATE TIMESTAMP NOT NULL,
		UPDATE_USER VARCHAR(2147483647) NOT NULL,
		CREATED_TIME TIMESTAMP NOT NULL,
		CREATED_USER INTEGER NOT NULL
);

/**********************************/
/* «Æ?«Ö«ëÙ£: deadletter */
/**********************************/
CREATE TABLE deadletter(
		message_name VARCHAR(200) NOT NULL,
		repository_name VARCHAR(255) NOT NULL,
		message_state VARCHAR(30) NOT NULL,
		error_message VARCHAR(200),
		sender VARCHAR(255),
		recipients TEXT NOT NULL,
		remote_host VARCHAR(255) NOT NULL,
		remote_addr VARCHAR(20) NOT NULL,
		message_body BYTEA NOT NULL,
		message_attributes BYTEA,
		last_updated TIMESTAMP NOT NULL
);

/**********************************/
/* «Æ?«Ö«ëÙ£: email_ack */
/**********************************/
CREATE TABLE email_ack(
		send_no INTEGER NOT NULL,
		send_time TIMESTAMP NOT NULL,
		moto_jpg_nm VARCHAR(2147483647),
		recv_time TIMESTAMP,
		recv_cnt INTEGER
);

/**********************************/
/* «Æ?«Ö«ëÙ£: inbox */
/**********************************/
CREATE TABLE inbox(
		message_name VARCHAR(200) NOT NULL,
		repository_name VARCHAR(255) NOT NULL,
		message_state VARCHAR(30) NOT NULL,
		error_message VARCHAR(200),
		sender VARCHAR(255),
		recipients TEXT NOT NULL,
		remote_host VARCHAR(255) NOT NULL,
		remote_addr VARCHAR(20) NOT NULL,
		message_body BYTEA NOT NULL,
		message_attributes BYTEA,
		last_updated TIMESTAMP NOT NULL
);

/**********************************/
/* «Æ?«Ö«ëÙ£: spool */
/**********************************/
CREATE TABLE spool(
		message_name VARCHAR(200) NOT NULL,
		repository_name VARCHAR(255) NOT NULL,
		message_state VARCHAR(30) NOT NULL,
		error_message VARCHAR(200),
		sender VARCHAR(255),
		recipients TEXT NOT NULL,
		remote_host VARCHAR(255) NOT NULL,
		remote_addr VARCHAR(20) NOT NULL,
		message_body BYTEA NOT NULL,
		message_attributes BYTEA,
		last_updated TIMESTAMP NOT NULL
);

/**********************************/
/* «Æ?«Ö«ëÙ£: user_authentication */
/**********************************/
CREATE TABLE user_authentication(
		user_id VARCHAR(255) NOT NULL,
		user_auth VARCHAR(1)
);

/**********************************/
/* «Æ?«Ö«ëÙ£: user_info */
/**********************************/
CREATE TABLE user_info(
		user_id VARCHAR(255) NOT NULL,
		user_pass VARCHAR(255),
		birth_day VARCHAR(8),
		sex INTEGER,
		location VARCHAR(2147483647),
		last_login TIMESTAMP,
		login_ip VARCHAR(15)
);

/**********************************/
/* «Æ?«Ö«ëÙ£: users */
/**********************************/
CREATE TABLE users(
		username VARCHAR(64) NOT NULL,
		pwdhash VARCHAR(50),
		pwdalgorithm VARCHAR(20),
		useforwarding SMALLINT,
		forwarddestination VARCHAR(255),
		usealias SMALLINT,
		alias VARCHAR(255)
);


ALTER TABLE USER_MASTER ADD CONSTRAINT IDX_USER_MASTER_PK PRIMARY KEY (USER_ID, LAST_LOGIN);

ALTER TABLE deadletter ADD CONSTRAINT IDX_deadletter_PK PRIMARY KEY (message_name, repository_name);
ALTER TABLE deadletter ADD CONSTRAINT deadletter_pkey UNIQUE (repository_name, message_name);

ALTER TABLE email_ack ADD CONSTRAINT IDX_email_ack_PK PRIMARY KEY (send_no);

ALTER TABLE inbox ADD CONSTRAINT IDX_inbox_PK PRIMARY KEY (message_name, repository_name);
ALTER TABLE inbox ADD CONSTRAINT inbox_pkey UNIQUE (repository_name, message_name);

ALTER TABLE spool ADD CONSTRAINT IDX_spool_PK PRIMARY KEY (message_name, repository_name);
ALTER TABLE spool ADD CONSTRAINT spool_pkey UNIQUE (repository_name, message_name);

ALTER TABLE user_authentication ADD CONSTRAINT IDX_user_authentication_PK PRIMARY KEY (user_id);

ALTER TABLE user_info ADD CONSTRAINT IDX_user_info_PK PRIMARY KEY (user_id);

ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (username);

