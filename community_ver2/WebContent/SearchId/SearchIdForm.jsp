<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
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

input[type=submit] {
    width: 100%;
    background-color: #005BAF;
    color: white;
    padding: 14px 20px;
    border: none;
    cursor: pointer;
}

</style>
</head>
<body>
<form action="FrontServlet" method="post" name="frm">
	<input type="hidden" name="command" value="search_id" />
	<table border="1" cellpadding="0" cellspacing="0" >
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
			<td rowspan="2" ><input type="submit"  value="아이디 찾기" onclick="return searchIdCheck()"></td>
		</tr>
		<tr>
			<td>휴대전화번호</td>
			<td><input type="text" name="phone"></td>
		</tr>
	</table>
</form>
</body>
</html>