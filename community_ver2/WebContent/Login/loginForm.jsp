<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
<script type="text/javascript" src="script/member.js"></script>
<style type="text/css">

html, body {
	margin: 20px;
	padding: 0;
	height: 100%;
	font-family: 함초롱돋움;
}


input[type=text]{
    width: 100%;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=password]{
    width: 100%;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}		


input[type=submit] {
    width: 100%;
    background-color: #005BAF;
    color: white;
    padding: 14px 20px;
    border: none;
    cursor: pointer;
}

input[type=button], input[type=reset] {
    background-color: #005BAF00;
    border: none;
    color: black;
    padding: 4px 9px;
    text-decoration: none;
    margin: 2px 1px;
    cursor: pointer;
}

</style>
</head>
<body>
<h2 align="center" style="font-family: DX회전목마; font-size: 30px">로그인</h2>
<form action="FrontServlet" method="post" name="frm">
	<input type="hidden" name="command" value="login"/>
	<table border="1" cellpadding="0" cellspacing="0" align="center" >
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" value="${userid}" placeholder="아이디"></td>
			<td rowspan="2" ><input type="submit"  value="로그인" onclick="return loginCheck()"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" size="21" name="pw" placeholder="비밀번호"></td>
		</tr>
	</table>
	&nbsp;	&nbsp;			
	<input type="button" value="아이디 찾기" onclick="search('FrontServlet?command=search_id_form')">			
	<input type="button" value="비밀번호 찾기" onclick="search('FrontServlet?command=search_pw_form')" > 		
	<input type="button" value="회원가입" onclick="joinView('FrontServlet?command=join_form')" >


</form>
</body>
</html>