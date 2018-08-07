<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
	font-size: 16px;
    text-align: left;
    padding: 8px;
    font-family: 인터파크고딕 M;
}

tr{background-color: #F0F8FF}

th {
    background-color: #4CAF50;
    color: white;
    
}

input[type=submit], [type=button] {
    width: 30%;
    background-color: #005BAF;
    color: white;
    padding: 14px 20px;
    border: none;
    cursor: pointer;
}

</style>
</head>
<body>

<h2>회원정보 수정</h2>
'*'항목은 변경 불가 항목입니다.
<form action="FrontServlet" method="post" name="frm">
	<input type="hidden" name="command" value="info_update">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" size="20" value="${getMember.name }" readonly="readonly">*</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="userid" size="20" value="${getMember.userid }" readonly="readonly">*

			</td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="password" name="pw" size="21"></td>
		</tr>
		<tr>
			<td>암호 확인</td>
			<td><input type="password" name="pw_check" size="21"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" size="20" value="${getMember.age}" readonly="readonly">*</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" size="20" value="${getMember.phone}"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" size="20" value="${getMember.address}"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" size="20" value="${getMember.email}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="확인" onclick="return joinCheck()">
			<input type="button" value="취소" onclick="location.href='FrontServlet?command=my_info'">
			</td>
		</tr>
	</table>
</form>

</body>
</html>