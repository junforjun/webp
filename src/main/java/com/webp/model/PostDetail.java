package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.PostDetailPK;
/**
 * MODEL autogen macro
 * PostDetail
 * @auther KIM
*/
@Entity
@Table(name="POST_DETAIL")
@IdClass(value = PostDetailPK.class)
public class PostDetail implements Serializable {
	public static final String TABLE = "POST_DETAIL";

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
	public Integer postNo;

	/** ポストタイトル */
	@Column(name = "POST_TITLE", nullable = false)
	public String postTitle;

	/** ポストサブタイトル */
	@Column(name = "POST_SUB_TITLE")
	public String postSubTitle;

	/** 整列順番 */
	@Column(name = "DISPLAY_ORDER")
	public String displayOrder;

	/** Googleマップ情報ありフラグ */
	@Column(name = "MAP_INFO_FLAG")
	public String mapInfoFlag;

	/** ファイル情報ありフラグ */
	@Column(name = "FILE_INFO_FLAG")
	public String fileInfoFlag;

	/** コンテンツ */
	@Column(name = "CONTENTS")
	public String contents;

	/** 生成ユーザID */
	@Id
	@Column(name = "CREATED_USER")
	public String createdUser;

	/** 生成時間 */
	@Id
	@Column(name = "CREATED_TIME")
	public Timestamp createdTime;

	/** 修正ユーザID */
	@Id
	@Column(name = "EDITED_USER")
	public String editedUser;

	/** 修正時間 */
	@Id
	@Column(name = "EDITED_TIME")
	public Timestamp editedTime;

}