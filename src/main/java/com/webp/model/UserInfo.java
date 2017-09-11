package com.webp.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * MODEL autogen macro
 * UserInfo
 * @auther KIM
*/
@Entity
@Table(name="USER_INFO")
public class UserInfo implements Serializable {
	public static final String TABLE = "USER_INFO";

	/** ユーザID */
	@Id
	@Column(name = "USER_ID")
	public String userId;

	/** ユーザパスワード */
	@Column(name = "USER_PASS", nullable = false)
	public String userPass;

	/** 性別 */
	@Column(name = "SEX")
	public String sex;

	/** 性 */
	@Column(name = "FIRST_NAME", nullable = false)
	public String firstName;

	/** 名 */
	@Column(name = "LAST_NAME", nullable = false)
	public String lastName;

	/** 認証済みフラグ */
	@Column(name = "IS_VERIFICATIONED", nullable = false)
	public String isVerificationed;

	/** 郵便番号 */
	@Column(name = "POST_CODE")
	public String postCode;

	/** 住所１ */
	@Column(name = "ADDRESS1")
	public String address1;

	/** 住所２ */
	@Column(name = "ADDRESS2")
	public String address2;

	/** プロファイル画像 */
	@Column(name = "AVATAR_FILE_LOC")
	public String avatarFileLoc;

	/** プロファイル文言 */
	@Column(name = "SELF_INTRODUCE_TEXT")
	public String selfIntroduceText;

	/** 非活性フラグ */
	@Column(name = "HIDDEN_FLAG", nullable = false)
	public String hiddenFlag;

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
		return "UserInfo [" + (userId != null ? "userId=" + userId + ", " : "") + "\r\n"
				+ (userPass != null ? "userPass=" + userPass + ", " : "") + (sex != null ? "sex=" + sex + ", " : "") + "\r\n"
				+ (firstName != null ? "firstName=" + firstName + ", " : "") + "\r\n"
				+ (lastName != null ? "lastName=" + lastName + ", " : "") + "\r\n"
				+ (isVerificationed != null ? "isVerificationed=" + isVerificationed + ", " : "") + "\r\n"
				+ (postCode != null ? "postCode=" + postCode + ", " : "") + "\r\n"
				+ (address1 != null ? "address1=" + address1 + ", " : "") + "\r\n"
				+ (address2 != null ? "address2=" + address2 + ", " : "") + "\r\n"
				+ (avatarFileLoc != null ? "avatarFileLoc=" + avatarFileLoc + ", " : "") + "\r\n"
				+ (selfIntroduceText != null ? "selfIntroduceText=" + selfIntroduceText + ", " : "") + "\r\n"
				+ (hiddenFlag != null ? "hiddenFlag=" + hiddenFlag + ", " : "") + "\r\n"
				+ (createdUser != null ? "createdUser=" + createdUser + ", " : "") + "\r\n"
				+ (createdTime != null ? "createdTime=" + createdTime + ", " : "") + "\r\n"
				+ (editedUser != null ? "editedUser=" + editedUser + ", " : "") + "\r\n"
				+ (editedTime != null ? "editedTime=" + editedTime : "") + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIsVerificationed() {
		return isVerificationed;
	}

	public void setIsVerificationed(String isVerificationed) {
		this.isVerificationed = isVerificationed;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAvatarFileLoc() {
		return avatarFileLoc;
	}

	public void setAvatarFileLoc(String avatarFileLoc) {
		this.avatarFileLoc = avatarFileLoc;
	}

	public String getSelfIntroduceText() {
		return selfIntroduceText;
	}

	public void setSelfIntroduceText(String selfIntroduceText) {
		this.selfIntroduceText = selfIntroduceText;
	}

	public String getHiddenFlag() {
		return hiddenFlag;
	}

	public void setHiddenFlag(String hiddenFlag) {
		this.hiddenFlag = hiddenFlag;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(String editedUser) {
		this.editedUser = editedUser;
	}

	public Timestamp getEditedTime() {
		return editedTime;
	}

	public void setEditedTime(Timestamp editedTime) {
		this.editedTime = editedTime;
	}

	public static String getTable() {
		return TABLE;
	}

}