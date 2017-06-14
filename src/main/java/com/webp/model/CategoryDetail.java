package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.CategoryDetailPK;
/**
 * MODEL autogen macro
 * CategoryDetail
 * @auther KIM
*/
@Entity
@Table(name="CATEGORY_DETAIL")
@IdClass(value = CategoryDetailPK.class)
public class CategoryDetail implements Serializable {
	public static final String TABLE = "CATEGORY_DETAIL";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** カテゴリコード */
	@Id
	@Column(name = "CATEGORY_CODE")
	public String categoryCode;

	/** カテゴリ名 */
	@Column(name = "CATECORY_NAME", nullable = false)
	public String catecoryName;

	/** 上位カテゴリコード */
	@Column(name = "PARENTS_CATEGORY_CODE")
	public String parentsCategoryCode;

	/** 太文字 */
	@Column(name = "FONT_BOLD_FLAG")
	public String fontBoldFlag;

	/** 文字色 */
	@Column(name = "FONT_COLOR_CODE")
	public String fontColorCode;

	/** トップカテゴリコード */
	@Column(name = "TOP_CATEGORY_FLAG")
	public String topCategoryFlag;

}