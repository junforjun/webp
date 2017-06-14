package com.webp.model.pk;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.webp.model.Reply;

/**
 * PK MODEL Class autogen macro
 * Reply
 * @auther KIM
*/
public class ReplyPK implements Serializable {
	public String userId;

	public String categoryCode;

	public String postNo;

	public String replyCode;

	@Override
	public int hashCode() {
	    return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
	    return super.equals(obj);
	}
}