package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.MenuMasterPK;
/**
 * MODEL autogen macro
 * MenuMaster
 * @auther KIM
*/
@Entity
@Table(name="MENU_MASTER")
@IdClass(value = MenuMasterPK.class)
public class MenuMaster implements Serializable {
	public static final String TABLE = "MENU_MASTER";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** メニューID */
	@Id
	@Column(name = "MENU_ID")
	public String menuId;

	/** メニュー名 */
	@Column(name = "MENU_NAME", nullable = false)
	public String menuName;

	/** 整列順番 */
	@Column(name = "DISPLAY_ORDER", nullable = false)
	public String displayOrder;

}