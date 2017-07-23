package com.webp.model;

import java.io.Serializable;

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

	/** ユーザブログURL */
	@Column(name = "URL_ID", nullable = false)
	public String urlId;

	/** ユーザニックネーム */
	@Column(name = "USER_NICK", nullable = false)
	public String userNick;

	/** 性 */
	@Column(name = "FIRST_NAME", nullable = false)
	public String firstName;

	/** 名 */
	@Column(name = "LAST_NAME", nullable = false)
	public String lastName;

	/** 認証済みフラグ */
	@Column(name = "IS_VERIFICATIONED", nullable = false)
	public String isVerificationed;

	/** 性別 */
	@Column(name = "SEX")
	public String sex;

	/** 郵便番号 */
	@Column(name = "POST_CODE")
	public String postCode;

	/** プロファイル画像 */
	@Column(name = "AVATAR_FILE_LOC")
	public String avatarFileLoc;

	/** プロファイル文言 */
	@Column(name = "SELF_INTRODUCE_TEXT")
	public String selfIntroduceText;

	/** 住所１ */
	@Column(name = "ADDRESS1")
	public String address1;

	/** 住所２ */
	@Column(name = "ADDRESS2")
	public String address2;

	/** ブログタイトル */
	@Column(name = "BLOG_TITLE")
	public String blogTitle;

	/** ブログサブタイトル */
	@Column(name = "BLOG_SUB_TITLE")
	public String blogSubTitle;

	/** 情報公開レベル */
	@Column(name = "INFO_OPEN_LEVEL")
	public String infoOpenLevel;

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + "\r\n  userPass=" + userPass + "\r\n  urlId=" + urlId + "\r\n  userNick=" + userNick
				+ "\r\n  firstName=" + firstName + "\r\n  lastName=" + lastName + "\r\n  isVerificationed=" + isVerificationed
				+ "\r\n  sex=" + sex + "\r\n  postCode=" + postCode + "\r\n  avatarFileLoc=" + avatarFileLoc
				+ "\r\n  selfIntroduceText=" + selfIntroduceText + "\r\n  address1=" + address1 + "\r\n  address2=" + address2
				+ "\r\n  blogTitle=" + blogTitle + "\r\n  blogSubTitle=" + blogSubTitle + "\r\n  infoOpenLevel=" + infoOpenLevel
				+ "]";
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

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogSubTitle() {
		return blogSubTitle;
	}

	public void setBlogSubTitle(String blogSubTitle) {
		this.blogSubTitle = blogSubTitle;
	}

	public String getInfoOpenLevel() {
		return infoOpenLevel;
	}

	public void setInfoOpenLevel(String infoOpenLevel) {
		this.infoOpenLevel = infoOpenLevel;
	}

}