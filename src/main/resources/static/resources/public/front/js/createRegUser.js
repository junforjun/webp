function step1() {

	jQuery.ajax({
		type : "POST",
		url : "/user/step1/",
		dataType:"json",
		data : {
			"id" : $("#id").val(),
			"pass" : $("#pass").val(),
		},

		success : function(data) {
			if($("#id").val() == "") {
				$('#id').tooltip('destroy');
				$("#idbox").attr("class", "input-group");
			} else if (data.message != null) {
				$("#id").attr("title", data.message);
				$("#idbox").attr("class", "input-group has-error");
				$('#id').tooltip({placement: 'right',trigger: 'manual'}).tooltip('show');


			} else {
				$('#id').tooltip('destroy');
				$("#idbox").attr("class", "input-group has-success");
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