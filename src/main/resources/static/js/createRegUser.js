function regUser() {

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
		url : "/user/regUser/",
		data : {
			"userId" : $("#userEmail").val(),
			"firstName" : $("#userfirstname").val(),
			"lastName" : $("#userlastname").val(),
			"userPass" : $("#userPassword").val(),
			"userNick" : $("#userNick").val(),
			"urlId" : $("#urlId").val(),
			"sex" : $("input[type=radio][id=userSex]:checked").val()
		},

		success : function(data) {
			alert(data);
			if (data == "1") {
				redirect("/" + $("#urlId").val());
			} else {
				alert(data);
			}
		},
		complete : function(data) {
			// alert("complete");
		},
		error : function(xhr, status, error) {
			alert("server error" + status);
			alert(error);

		}
	});

}



function changeURL(control) {
	var splitedId = control.value.split("@");
	if (splitedId.length == 2) {
		$("#urlId").val(splitedId[0]);
		$("#userNick").val(splitedId[0]);

	}
}