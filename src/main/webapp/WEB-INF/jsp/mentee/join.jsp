<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영록이의 즐거운 회원가입시간</title>

<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<%-- css --%>
<%-- js --%>
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!------ 위에는 회원가입에 필요한 것들  ---------->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style>
	.joininfo{
		width : 300px;
	}
</style>

</head>
<body>
<div class ="container">
<h1>하이요 회원가입 하고 시펑?!</h1>
	<div class ="col-lg-9" style="border: 1px solid greenyellow; padding:5px;">
		<form id="signup" action="join" method="post">
			<div>
				<label for="username" >이름</label>
				<input class="joininfo" name="name" type="text" id="username" placeholder="이름은 최소 2글자 이상입니다." 
				oninput="namecheck()" maxlength="4"/>
			</div>
			<div>
				<label for="usernick">닉네임</label>
				<input class="joininfo" name="nick" type="text" id="usernick" placeholder="닉네임을 입력해주세요" 
				oninput="nickcheck()" maxlength="10"/>
			</div>
			<div>
				<label for="useremail">이메일</label>
				<input class="joininfo" name="email" type="email" id="useremail" placeholder="이메일 양식에맞춰 입력해주세요."
				oninput="emailcheck()"/>
			</div>
			<div>
				<label for="userpassword">비밀번호</label>
				<input class="joininfo" type="password" name="userpassword" id="userpassword" placeholder="비밀번호 8자이상입니다."
				oninput="passcheck()" />
			</div>
			<div>
				<label for="userpassword">비밀번호확인</label>
				<input class="joininfo" type="password" name="userconfpassword" id="userconfpassword" placeholder="입력하신 비밀번호와 똑같이 입력"
				oninput="passcheck()" />
			</div>
			<div>
				<button type="button" id="joinbut" onClick="joinbutton()">회원가입하기</button>
			</div>
		</form>
	</div>
</div>

<script>
/* name 은 2일 경우 회원가입가능 */
var namecheckval=0;
/* nick 도 2일 경우 회원가입 가능 */
var nickcheckval=0;
/* email 도 2일 경우 회원가입 가능 */
var emailcheckval=0;
/* password 도 2일 경우 회원가입 가능 */
var passcheckval=0;

function namecheck() {
    var nameval = $('#username').val();
    var namerole = /^[가-힣]{2,4}$/;
	var nametest = namerole.test(nameval);    
    
    if(nameval == "") {
        namecheckval = 1;
    }else if(nametest == true && nameval.length>1){
        namecheckval = 2;
    }else {
        namecheckval = 1;
    }
}

function nickcheck() {
    var nickval = $("#usernick").val();
    var nickrole = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\*]+$/;
    var nicktest = nickrole.test(nickval);
    
    console.log("ajax전 ")
    
    $.ajax({
        type : "POST",
        data : {
            "nick" : nickval,
        },
        url : "checknick.do" ,
        success : function(data) {
            console.log(data);
            console.log("성공");
            if(nickval== "" && data == '0') {
                $("#usernick").css("background-color", "white");
                nickcheckval = 0;
            } else if (data == '0' && nicktest == true && $("#usernick").val().length > 0) {
                $("#usernick").css("background-color", "#B0F6AC");
                nickcheckval = 2;
            } else if (data == '1') {
                $("#usernick").css("background-color", "#FA5858");
                nickcheckval = 1;
            }else if(data=='0') {
                $("#usernick").css("background-color", "#FA5858");
                nickcheckval = 1;
            }
        }
    });
}

function emailcheck() {
    var emailval = $('#useremail').val();
    var emailrole = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var emailtest = emailrole.test(emailval);
    
    $.ajax({
        data : {
            email : emailval
        },
        url : "checkemail.do" , 
        success : function(data) {
            if(emailval=="" && data=='0' ) {
                $("#useremail").css("background-color", "white");
                emailCheck = 0;
            } else if (data == '0' && emailtest == true && $("#useremail").val().length > 0) {
                $("#useremail").css("background-color", "#B0F6AC");
                emailCheck = 2;
            } else if (data == '1') {
                $("#useremail").css("background-color", "#FA5858");
                emailCheck = 0;
            }else if(data=='0' && emailtest == false) {
                $("#useremail").css("background-color", "#FA5858");
                emailCheck = 0;
            }
        }
    });
}

function passcheck() {
    var passval = $('#userpassword').val();
    var passconfval = $('#userconfpassword').val();
    
    if(passconfval=="" && (passval != passconfval || passval == passconfval || $('#userconfpassword').val().length < 8 || $('#userpassword').val().length < 8)){
        $("#userconfpassword").css("background-color", "#FA5858");
        passcheckval = 0;
    }else if (passval == passconfval && $('#userpassword').val().length > 7) {
        $("#userconfpassword").css("background-color", "#B0F6AC");
        passcheckval = 2;
    } else if (passval != passconfval) {
        passcheckval = 0;
        $("#userconfpassword").css("background-color", "#FA5858");
        
    }
}

function joinbutton() {
    if($("#usernick").val() == "" || $("#useremail").val()=="" || $("#username").val() == "" || $("#userpassword").val() == "" || $("#userconfpassword").val() == "") {
    	swal({
	        text: "공백을 확인해주세요.",
	        button:"확인"
	      });
        return false;
    }else if(namecheckval == 0){
    	swal({
	        text: "이름 2~4글자 입력해주세요.",
	        button:"확인"
	      });
		return false;
    }else if(emailcheckval == 0){
    	swal({
	        text: "이미 사용중인 이메일입니다.",
	        button:"확인"
	    });
		return false;
    }else if(passcheckval == 0){
    	swal({
	        text: "비밀번호 값을 체크해주세요.",
	        button:"확인"
	      });
		return false;
    }else if(nickcheckval == 0){
    	swal({
	        text: "이미 사용중인 닉네임입니다.",
	        button:"확인"
	      });
		return false;
    }else if($("#userpassword").val().length < 8){
		swal({
	        text: "비밀번호는 8자 이상입력해주세요..",
	        button:"확인"
	      });
		return false;
	}else {
      		  swal({
      		        icon: "success",
      		        text: $("#username").val() + "님 회원가입을 축하드립니다^^",
      		        timer:3000,
      		        button:"확인"
      		        }).then((value) => {
      		       		document.getElementById('signup').submit();
      		        });
	}
}
</script>
</body>
</html>