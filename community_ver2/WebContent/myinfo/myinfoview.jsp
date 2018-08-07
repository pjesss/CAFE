<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty loginUser}">
	<script>
	alert("회원 탈퇴 되었습니다");
	</script>
	<jsp:forward page="../FrontServlet?command=free_board_list "></jsp:forward>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=button] {
    width: 50%;
    background-color: #005BAF;
    color: white;
    padding: 14px 20px;
    border-bottom: 1px solid white;
    cursor: pointer;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<script type="text/javascript" src="script/buysalelist.js"></script>
</head>
<body>
<center>
<input type="button" value="회원정보 수정하기" onclick="location.href='FrontServlet?command=info_update_form'"><br>
<input type="button" value="회원 탈퇴" onclick="location.href='myinfo/dropCheck.jsp'"> <br>
<input type="button" value="내 글 보러가기" onclick="location.href='FrontServlet?command=free_board_myview'"><br>
<input type="button" value="구매목록" onclick="location.href='FrontServlet?command=buy_list'"><br>
<input type="button" value="판매목록" onclick="location.href='FrontServlet?command=sale_list'"><br>
<input type="button" value="캐쉬충전" onclick="location.href='FrontServlet?command=cash_charge_form'"><br>
</center>
</body>
</html>