<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여긴 내사이트야! 넌 로그인부터 해보렴 ^_^</title>
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<%-- css --%>
<%-- js --%>
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!------ 위에는 회원가입에 필요한 것들  ---------->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<div>
	<label>이메일</label>
	<input type="email" name="email" id="email" placeholder="이메일를 입력해주세요" ${cookie.email.value}/>
	<label>비밀번호</label>
	<input type="password" name="pwd" id="pwd" placeholder="비밀번호를를 입력해주세요"/>
	<label>아이디 저장</label>
	<input type="checkbox" name="save" id="save" ${cookie.save.value}/>
	<input type="button" id="loginbtn" onclick="loginact()" value = "로그인" />
<script>
function loginact() {
    /* var saveid = null;
    if($('#saveid').prop("checked")) {
        saveid = 1;
    }else {
        saveid = null;
    } */
    
    $.ajax({
        type : "POST" ,
        data : {
            email : $("#email").val() , 
            pwd : $("#pwd").val() ,
            save : $("#save").val()
        },
        url : "login.do" , 
        success : function(data) {
            console.log(data);
            if(data == 1) {
                if(document.referrer == ""){
			    	location.href = "../mainpage/main";
			    }else{
					location.href = document.referrer;
			    }
            } else {
                swal({
                    text : "회원아이디와 비밀번호가 일치하지 않습니다." ,
                    button : "확인"
                })
            }
        }
    });
}
</script>
</div>
</body>
</html>