<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
#loginForm{
	width:300px;
}
</style>


<form action="/member.login.do" method="post" id="loginForm">
	<fieldset>
		<legend>로그인</legend>
		ID : <input type="text" name="userId"/><br>
		PW : <input type="password" name="userPwd"/><br>
		<input type="submit" value="로그인"><br>
	</fieldset>
</form>

</body>
</html>