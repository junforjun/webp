/**
 * index.js
 */
function loginChk() {
	jQuery.ajax({
		type : "POST",
		url : "/login/",
		data : {
			"username" : $("#username").val(),
			"password" : $("#password").val()
		},
		success : function(data) {

			if (data == "") {
				alert("Check ID or Password");
			} else {
				redirect("/mail/")
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

function regUser() {


	if( $('#id').val() == "" ||  $('#id').val().length < 4) {
		alert("Check Id");
		return;
	}

	if( $('#pass').val() == "" ||  $('#pass').val().length < 4) {
		alert("Check password");
		return;
	}

	if( $('#repass').val() != $('#repass').val()) {
		alert("Check repass");
		return;
	}

	if( $('#name').val() == "" ||  $('#name').val().length < 2) {
		alert("Check Nick");
		return;
	}

	jQuery.ajax({
		type : "POST",
		url : "/regUser/",
		data : {
			"username" : $("#id").val(),
			"password" : $("#pass").val(),
			"name" : $("#name").val()
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
$(function() {
	var modalContents = $(".modal-contents");
	var modal = $("#defaultModal");

	$('.onlyAlphabetAndNumber').keyup(function(event) {
		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
			var inputVal = $(this).val();
			$(this).val($(this).val().replace(/[^_a-z0-9]/gi, ''));
		}
	});

	$('#id').keyup(function(event) {

		var divId = $('#trId');

		if ($('#id').val().length < 4) {
			divId.removeClass("has-success");
			divId.addClass("has-error");
		} else {
			divId.removeClass("has-error");
			divId.addClass("has-success");
		}
	});

	$('#pass').keyup(function(event) {

		var divId = $('#trPass');

		if ($('#pass').val().length < 4) {
			divId.removeClass("has-success");
			divId.addClass("has-error");
		} else {
			divId.removeClass("has-error");
			divId.addClass("has-success");
		}
	});

	$('#repass').keyup(function(event) {

		var divId = $('#trRepass');

		if ($('#repass').val() != $('#pass').val()) {
			divId.removeClass("has-success");
			divId.addClass("has-error");
		} else {
			divId.removeClass("has-error");
			divId.addClass("has-success");
		}
	});

	$('#name').keyup(function(event) {

		var divId = $('#trName');

		if ($('#name').val().length < 2) {
			divId.removeClass("has-success");
			divId.addClass("has-error");
		} else {
			divId.removeClass("has-error");
			divId.addClass("has-success");
		}
	});

})
