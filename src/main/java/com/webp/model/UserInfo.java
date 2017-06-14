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
 * UserInfo
 * @auther KIM
*/
@Entity
@Table(name="USER_INFO")
public class UserInfo implements Serializable {
	public static final String TABLE = "USER_INFO";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** ユーザパスワード */
	@Column(name = "USER_PASS", nullable = false)
	public String userPass;

	/** ユーザブログURL */
	@Column(name = "URL_ID", nullable = false)
	public String urlId;

	/** ユーザニックネーム */
	@Column(name = "USER_NICK", nullable = false)
	public String userNick;

	/** 性 */
	@Column(name = "FIRST_NAME", nullable = false)
	public String firstName;

	/** 名 */
	@Column(name = "LAST_NAME", nullable = false)
	public String lastName;

	/** 認証済みフラグ */
	@Column(name = "IS_VERIFICATIONED", nullable = false)
	public String isVerificationed;

	/** 性別 */
	@Column(name = "SEX")
	public String sex;

	/** 郵便番号 */
	@Column(name = "POST_CODE")
	public String postCode;

	/** プロファイル画像 */
	@Column(name = "AVATAR_FILE_LOC")
	public String avatarFileLoc;

	/** プロファイル文言 */
	@Column(name = "SELF_INTRODUCE_TEXT")
	public String selfIntroduceText;

	/** 住所１ */
	@Column(name = "ADDRESS1")
	public String address1;

	/** 住所２ */
	@Column(name = "ADDRESS2")
	public String address2;

	/** 情報公開レベル */
	@Column(name = "INFO_OPEN_LEVEL")
	public String infoOpenLevel;

}