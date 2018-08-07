<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<c:if test="${empty userid}">
	입력하신 정보에 해당하는 ID가 없습니다.<br>
</c:if>
<c:if test="${not empty userid}">
	아이디 : ${userid } 입니다.<br>
	<input type="button" value="비밀번호 찾기" onclick="location.href='FrontServlet?command=search_pw_form&userid=${userid}'"/>
</c:if>
<input type="button" value="다시 입력하기"  onclick="location.href='FrontServlet?command=search_id_form'">
<input type="button" value="닫기"  onclick="Wclose()">
</body>
</html>