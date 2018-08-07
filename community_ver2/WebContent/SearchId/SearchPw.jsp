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
<c:if test="${empty pw}">
	입력하신 정보가 존재하지 않습니다.<br>
</c:if>
<c:if test="${not empty pw}">
	비밀번호는 : ${pw} 입니다.<br>
</c:if>
<input type="button" value="닫기"  onclick="Wclose()">
</body>
</html>