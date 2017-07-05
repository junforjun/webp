/**
 *
 */
function getmail() {
	jQuery.ajax({
		type : "GET",
		url : "/mail/get",
		dataType:"json",
		success : function(data) {

			if (data == null) {
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
function redirectDetail(mailId) {
	redirect("/mail/getDetail?mailId=" + mailId)



}
function sendEmail() {
	jQuery.ajax({
		type : "POST",
		url : "/mail/sendMail",
		data : {
			"to" : $("#to").val(),
			"cc" : $("#cc").val(),
			"bcc" : $("#bcc").val(),
			"subject" : $("#subject").val(),
			"message" : tinyMCE.activeEditor.getContent({format : 'raw'})
		},
		success : function(data) {

			if (data != "1") {
				alert(data);
			} else {
				 $("#to").val("");

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

