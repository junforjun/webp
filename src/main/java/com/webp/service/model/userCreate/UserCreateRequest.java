package com.webp.service.model.userCreate;

import com.webp.service.model.service.common.ApiRequest;

public class UserCreateRequest extends ApiRequest {
	/** ユーザID */
	public String userId;

	/** ユーザパスワード */
	public String userPass;

	/** ユーザブログURL */
	public String urlId;

	/** ユーザニックネーム */
	public String userNick;

	/** 性別 */
	public String sex;

	/** 性 */
	public String firstName;

	/** 名 */
	public String lastName;

	/** 認証済みフラグ */
	public String isVerificationed;

	/** 郵便番号 */
	public String postCode;

	/** 住所１ */
	public String address1;

	/** 住所２ */
	public String address2;

	/** プロファイル画像 */
	public String avatarFileLoc;

	/** プロファイル文言 */
	public String selfIntroduceText;

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

}
