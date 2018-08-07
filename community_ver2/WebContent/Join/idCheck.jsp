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
	<h2>아이디 중복확인</h2>
	<form action="FrontServlet" method="get" name="frm">
    	 <input type="hidden" name="command" value="idCheck">
		아이디 <input type="text" name="userid" value="${userid}">
		<input type="submit" value="중복 체크">
		<br>
		<c:if test="${result==1}">
			<script type="text/javascript">
				//현재 열려 있는 창 opener의 userid값
				opener.document.frm.userid.value="";
			</script>
			${userid}은(는) 이미 사용 중입니다.<br> 다시 입력해주세요.
		</c:if>
		<c:if test="${result==-1}">
			${userid}은(는) 사용 가능한 아이디 입니다.<br>
			<input type="button" value="사용하기" onclick="idOk('${userid}')">
		</c:if>
		
	</form>
</body>
</html>