package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.ReplyPK;
/**
 * MODEL autogen macro
 * Reply
 * @auther KIM
*/
@Entity
@Table(name="REPLY")
@IdClass(value = ReplyPK.class)
public class Reply implements Serializable {
	public static final String TABLE = "REPLY";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** カテゴリコード */
	@Id
	@Column(name = "CATEGORY_CODE")
	public String categoryCode;

	/** ポスト番号 */
	@Id
	@Column(name = "POST_NO")
	public String postNo;

	/** Replyコード */
	@Id
	@Column(name = "REPLY_CODE")
	public String replyCode;

	/** 上位Replyコード */
	@Column(name = "PARENTS_REPLY_CODE")
	public String parentsReplyCode;

	/** Reply内容 */
	@Column(name = "CONTENTS", nullable = false)
	public String contents;

	/** ファイルありフラグ */
	@Column(name = "FILE_INFO_FLAG", nullable = false)
	public String fileInfoFlag;

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

	/** 非活性フラグ */
	@Column(name = "HIDDEN_FLAG", nullable = false)
	public String hiddenFlag;

}