<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${message=='enough' }">
		<script type="text/javascript">
			alert('구입이 완료되었습니다.');
			window.close();
			window.opener.parent.location.href="FrontServlet?command=market_board_list";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert('잔액이 부족합니다.\n확인 후 다시 시도해주세요');
			window.close();
		</script>
	</c:otherwise>
</c:choose>


</body>
</html>