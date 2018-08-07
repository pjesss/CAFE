<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css"> 
<script type="text/javascript" src="/script/freeboard.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>상세글 보기</h1>
		<table>
			<tr>
				<th>보낸 사람</th>
				<td>${note.toid}</td>
			</tr>
			<tr>
				<th>받은 사람</th>
				<td>${note.userid}</td>
				<th>보낸 시간</th>
				<td><fmt:formatDate value="${note.notedate}" pattern="yy-MM-dd hh:mm:ss"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${note.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${note.content}</pre></td>
			</tr>
		
		</table>	
		<input type="button" name="update" value="뒤로가기" onclick="location.href='FrontServlet?command=note_main'">
	</div>
</body>
</html>