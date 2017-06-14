package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.MenuDetailPK;
/**
 * MODEL autogen macro
 * MenuDetail
 * @auther KIM
*/
@Entity
@Table(name="MENU_DETAIL")
@IdClass(value = MenuDetailPK.class)
public class MenuDetail implements Serializable {
	public static final String TABLE = "MENU_DETAIL";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** メニューID */
	@Id
	@Column(name = "MENU_ID")
	public String menuId;

	/** メニュー詳細 */
	@Column(name = "MENU_DETAIL")
	public String menuDetail;

}