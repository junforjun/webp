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
 * UserDetail
 * @auther KIM
*/
@Entity
@Table(name="USER_DETAIL")
public class UserDetail implements Serializable {
	public static final String TABLE = "USER_DETAIL";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** ユーザニックネーム */
	@Column(name = "USER_NICK", nullable = false)
	public String userNick;

	/** ユーザブログURL */
	@Column(name = "URL_ID", nullable = false)
	public String urlId;

	/** ブログタイトル */
	@Column(name = "BLOG_TITLE")
	public String blogTitle;

	/** ブログサブタイトル */
	@Column(name = "BLOG_SUB_TITLE")
	public String blogSubTitle;

	/** プロファイル画像 */
	@Column(name = "AVATAR_FILE_LOC")
	public String avatarFileLoc;

	/** 情報公開レベル */
	@Column(name = "INFO_OPEN_LEVEL")
	public String infoOpenLevel;

	/** プロファイル文言 */
	@Column(name = "SELF_INTRODUCE_TEXT")
	public String selfIntroduceText;

	/** 非活性フラグ */
	@Column(name = "HIDDEN_FLAG", nullable = false)
	public String hiddenFlag;

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