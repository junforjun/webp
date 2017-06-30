package com.webp.service.model.userCreate;

import com.webp.service.model.service.common.ApiRequest;

public class UserCreateRequest extends ApiRequest {
	public String userPassword;
	public String userEmail;
	public String userfirstname;
	public String userlastname;
	public String userID;
	public String userSex;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserfirstname() {
		return userfirstname;
	}

	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Override
	public String toString() {
		return "UserCreateRequest [userPassword=" + userPassword + ", userEmail=" + userEmail + ", userfirstname="
				+ userfirstname + ", userlastname=" + userlastname + ", userID=" + userID + ", userSex=" + userSex
				+ "]";
	}

}
