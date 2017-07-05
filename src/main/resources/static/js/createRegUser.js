function regUser() {
	if ($('#userfirstname').val() == "" || $('#userfirstname').val().length > 10) {
		alert("Check First name");
		return;
	}
	if ($('#userlastname').val() == "" || $('#userlastname').val().length > 10) {
		alert("Check Last name");
		return;
	}
	if ($('#userID').val() == "" || $('#userID').val().length < 4) {
		alert("More than 4 characters");
		return;
	}
	if ($('#userEmail').val() == "" || $('#userEmail').val().length < 4) {
		alert("Check Email");
		return;
	}
	if ($('#userPassword').val() == "" || $('#userPassword').val().length < 4) {
		alert("Check Password");
		return;
	}
	if ($('#userPassword2').val() == "" || $('#userPassword2').val().length < 4) {
		alert("Check Password2");
		return;
	}
	if ($('#userPassword').val() != $('#userPassword2').val()) {
		alert("패스워드가 다름");
		return;
	}

/*	if ($('#agree').val() == "") {
		alert("동의해");
		return;
	}
	alert("Male" + $("agree").val());*/

	jQuery.ajax({
		type : "POST",
		url : "/regUser/",
		data : {
			"userfirstname" : $("#userfirstname").val(),
			"userlastname" : $("#userlastname").val(),
			"userEmail" : $("#userEmail").val(),
			"userID" : $("#userID").val(),
			"userPassword" : $("#userPassword").val(),
			"userSex" : $("input[type=radio][id=userSex]:checked").val()
		},
		success : function(data) {
			if (data != "1") {
				alert(data);
			} else {
				alert("Welcome To Funble Mail Server");
				$("#dismiss").click();
			}
		},
		complete : function(data) {
			// alert("complete");
		},
		error : function(xhr, status, error) {
			alert("server error" + status);
		}
	});

}