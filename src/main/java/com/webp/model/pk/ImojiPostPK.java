package com.webp.model.pk;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.webp.model.ImojiPost;

/**
 * PK MODEL Class autogen macro
 * ImojiPost
 * @auther KIM
*/
public class ImojiPostPK implements Serializable {
	public String userId;

	public String postNo;

	public String replyCode;

	public String imojiCode;

	public Integer imojiOrder;

	@Override
	public int hashCode() {
	    return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
	    return super.equals(obj);
	}
}