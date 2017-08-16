package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

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

	/** contents */
	@Column(name = "CONTESTS", nullable = false)
	public String contests;

	/** 整列順番 */
	@Column(name = "DISPLAY_ORDER")
	public String displayOrder;

	/** Googleマップ情報ありフラグ */
	@Column(name = "MAP_INFO_FLAG")
	public String mapInfoFlag;

	/** ファイル情報ありフラグ */
	@Column(name = "FILE_INFO_FLAG")
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

	@Override
	public String toString() {
		return "PostDetail [" + (userId != null ? "userId=" + userId + "\r\n " : "")
				+ (categoryCode != null ? "categoryCode=" + categoryCode + "\r\n " : "")
				+ (postNo != null ? "postNo=" + postNo + "\r\n " : "")
				+ (postTitle != null ? "postTitle=" + postTitle + "\r\n " : "")
				+ (postSubTitle != null ? "postSubTitle=" + postSubTitle + "\r\n " : "")
				+ (contests != null ? "contests=" + contests + "\r\n " : "")
				+ (displayOrder != null ? "displayOrder=" + displayOrder + "\r\n " : "")
				+ (mapInfoFlag != null ? "mapInfoFlag=" + mapInfoFlag + "\r\n " : "")
				+ (fileInfoFlag != null ? "fileInfoFlag=" + fileInfoFlag + "\r\n " : "")
				+ (createdUser != null ? "createdUser=" + createdUser + "\r\n " : "")
				+ (createdTime != null ? "createdTime=" + createdTime + "\r\n " : "")
				+ (editedUser != null ? "editedUser=" + editedUser + "\r\n " : "")
				+ (editedTime != null ? "editedTime=" + editedTime : "") + "]";
	}

}