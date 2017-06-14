package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.AttchedFilePK;
/**
 * MODEL autogen macro
 * AttchedFile
 * @auther KIM
*/
@Entity
@Table(name="ATTCHED_FILE")
@IdClass(value = AttchedFilePK.class)
public class AttchedFile implements Serializable {
	public static final String TABLE = "ATTCHED_FILE";

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

	/** ファイル順番 */
	@Id
	@Column(name = "FILE_ORDER")
	public String fileOrder;

	/** 実サーバファイル位置 */
	@Column(name = "FILE_LOCATION", nullable = false)
	public String fileLocation;

}