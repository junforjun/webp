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
 * ImojiMaster
 * @auther KIM
*/
@Entity
@Table(name="IMOJI_MASTER")
public class ImojiMaster implements Serializable {
	public static final String TABLE = "IMOJI_MASTER";

	/** imojiコード */
	@Id
	@Column(name = "IMOJI_CODE")
	public String imojiCode;

	/** Imoji説明 */
	@Column(name = "IMOJI_DESC")
	public String imojiDesc;

	/** 非活性フラグ */
	@Column(name = "HIDDEN_FLAG")
	public String hiddenFlag;

}