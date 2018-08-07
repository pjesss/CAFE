<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/freeboard.css">
<script type="text/javascript" src="script/freeboard.js"></script>
</head>
<!--  제목 글쓴이 작성일 조회수 -->
<body>
	<form action="FrontServlet?command=free_board_write" method="post">
		<div id="wrap" align="center">
		<h2 align="center">글쓰기</h2>
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" size="65" name="title"></td>
				</tr>
				<tr>
					<td>글</td>
					<td><textarea rows="20" cols="50" name="content"></textarea></td>
				</tr>
			</table>
			<input align="right" type="submit" value="등록하기" onclick="return writeCheck()"> 
			<input type="button" name="update" value="목록으로 가기" onclick="location.href='FrontServlet?command=free_board_list'">
		</div>
	</form>
</body>
</html>