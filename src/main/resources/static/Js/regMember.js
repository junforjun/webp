
function chkEmail(eMail){
	if(eMail == "" ) {
		document.all("emailChkBox").innerHTML="";
		return;
	}

	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;

	if (!eMail.match(regExp)) {
		document.all("emailChkBox").innerHTML="<font color='#A70300'>This is not a valid e-mail format.</font>";
		return false;
	} else {
		chkEmailToServer(eMail);
		return true;
	}
}

function chkEmailToServer(eMail) {
    jQuery.ajax({
          type:"GET",
          url:"http://localhost:8080/regMember/chkEmail",
//          dataType:"JSON",
          data:{"eMail" : eMail} ,
          success : function(data) {
               if(data == 0) {
            	   document.all("emailChkBox").innerHTML="<font color='#00C41A'>OK</font>";
               } else if(data == 1) {
            	   document.all("emailChkBox").innerHTML="<font color='#A70300'>already used E-mail</font>";
               }
          },
          complete : function(data) {
//        	  alert("complete");
          },
          error : function(xhr, status, error) {
               alert("server error" + status);
          }
    });

};


function chkRePass(pass, rePass){
	if(pass == "" || rePass == "") {
		document.all("passChkBox").innerHTML="";
		return;
	}

	if(pass.length < 4) {
		document.all("passChkBox").innerHTML="<font color='#A70300'>Password is too short</font>";
		return false;
	}

	if (pass == rePass) {
		document.all("passChkBox").innerHTML="<font color='#00C41A'>OK</font>";
		return true;
	} else {
		document.all("passChkBox").innerHTML="<font color='#A70300'>Check RePssword</font>";
		return false;
	}
}