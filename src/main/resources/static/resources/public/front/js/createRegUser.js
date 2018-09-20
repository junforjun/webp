var okFlagId = false;
var okFlagPass = false;

function step1_id() {
	jQuery.ajax({
		type : "POST",
		url : "/user/step1/id",
		dataType:"json",
		data : {
			"email" : $("#id").val(),
		},
		success : function(data) {
			if($("#id").val() == "") {
				$('#id').tooltip('destroy');
				$("#idbox").attr("class", "input-group");
				$("#nextBtn").attr("disabled", "disabled");
			} else if (data.message != null) {
				$("#id").attr("title", data.message);
				$("#idbox").attr("class", "input-group has-error");
				$('#id').tooltip({placement: 'right',trigger: 'manual'}).tooltip('show');
				$("#nextBtn").attr("disabled", "disabled");
			} else {
				$('#id').tooltip('destroy');
				$("#idbox").attr("class", "input-group has-success");
				okFlagId = true;
				if(okFlagPass) {
					$("#nextBtn").prop( "disabled", false );
				}
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

function step1_pass() {
	jQuery.ajax({
		type : "POST",
		url : "/user/step1/pass",
		dataType:"json",
		data : {
			"pass" : $("#pass").val(),
		},
		success : function(data) {
			if($("#pass").val() == "") {
				$('#pass').tooltip('destroy');
				$("#passbox").attr("class", "input-group");

			} else if (data.message != null) {
				$("#pass").attr("title", data.message);
				$("#passbox").attr("class", "input-group has-error");
				$('#pass').tooltip({placement: 'right',trigger: 'manual'}).tooltip('show');
				$("#nextBtn").attr("disabled", "disabled");
			} else {
				$('#pass').tooltip('destroy');
				$("#passbox").attr("class", "input-group has-success");
				okFlagPass = true;
				if(okFlagId) {
					$("#nextBtn").prop( "disabled", false );
				}
			}
		},
		complete : function(data) {

		},
		error : function(xhr, status, error) {
			alert("server error" + status);
			alert(error);
		}
	});
}

function nextStep() {
	step1_id();
	step1_pass();

	if(okFlagId) {
		page_move("");
	}
}

function changeURL(control) {
	var splitedId = control.value.split("@");
	if (splitedId.length == 2) {
		$("#urlId").val(splitedId[0]);
		$("#userNick").val(splitedId[0]);

	}
}