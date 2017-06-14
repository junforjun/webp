package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Id;

import com.webp.model.pk.ImojiPostPK;
/**
 * MODEL autogen macro
 * ImojiPost
 * @auther KIM
*/
@Entity
@Table(name="IMOJI_POST")
@IdClass(value = ImojiPostPK.class)
public class ImojiPost implements Serializable {
	public static final String TABLE = "IMOJI_POST";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** ポスト番号 */
	@Id
	@Column(name = "POST_NO")
	public String postNo;

	/** Replyコード */
	@Id
	@Column(name = "REPLY_CODE")
	public String replyCode;

	/** Imojiコード */
	@Id
	@Column(name = "IMOJI_CODE", nullable = false)
	public String imojiCode;

	/** Imojiカウント */
	@Column(name = "IMOJI_COUNT", nullable = false)
	public Integer imojiCount;

	/** Imoji順番 */
	@Id
	@Column(name = "IMOJI_ORDER")
	public Integer imojiOrder;

}