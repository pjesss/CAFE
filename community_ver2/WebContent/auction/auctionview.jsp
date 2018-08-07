<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./script/auction.js"></script>

<style type="text/css">
html, body {
	margin: 20px;
	padding: 0;
	height: 100%;
}

.header {
	width: 100%;
	height: 40%;
	background: white;
	text-align: center;
	float: left;
	
	
}

.section {
	width: 100%;
	height: 20%;
	float: left;
	background: white;
text-align: center;
	
	
}

.footer {
	width: 100%;
	height: 40%;
	float: left;
	background: white;
	text-align: center;
	
	
	
}

.article1 {
	width: 49%;
	height: 99%;
	float: left;
	background: white;
	text-align: center;
	/* border: 1px solid gray; */
	
}
.article2 {
	width: 49%;
	height: 49%;
	float: left;
	background: white;
	text-align: center;
	
	text-align: center;
	font-size: 100px;
}
.article3 {
	width: 49%;
	height: 49%;
	float: left;
	background: white;
	text-align: center;
	font-size: 40px;
	
}
.article4 {
	width: 24.5%;
	height: 99%;
	float: left;
	background: white;
	text-align: center;
	font-size: 40px;
	
}
.article5 {
	width: 49%;
	height: 99%;
	float: left;
	background: white;
	text-align: center;
}
.article6 {
	width: 49%;
	height: 99%;
	float: left;
	background: white;
	text-align: center;
}
.article7 {
	width: 49%;
	height: 99%;
	float: left;
	background: white;
	text-align: center;
	font-size: 30px;
}

</style>
</head>
<body>

<script >
	
		//var SetTime = 24*60*60;		// 최초 설정 시간(기본 : 초)

		//var SetTime = (24*60*60)-(${goneTime});
		var SetTime = 120-(${goneTime});

		function msg_time() {	// 1초씩 카운트

			m = Math.floor(SetTime/(60*60))+ "."+ Math.floor(SetTime/60%60) + "." + (SetTime % 60) ;	// 남은 시간 계산
			
			var msg = " <font color='red'>" + m + "</font>";
			
			document.all.ViewTimer.innerHTML = msg;		// div 영역에 보여줌 
					
			SetTime--;					// 1초씩 감소
			
			if (SetTime < 0) {			// 시간이 종료 되었으면..
				
				clearInterval(tid);		// 타이머 해제
				alert("종료");
			}
			
		}

		window.onload = function TimerStart(){ tid=setInterval('msg_time()',1000) };
		
	</script>
	<header class="header">
		<article class="article1"><img alt="사진 없음" src="${arrImglocal[0]}" width="150"></article>
		<article class="article2" id="ViewTimer"></article>
		<article class="article3">현재 가격:<br>${vo.endPrice}</article>
	</header>

	<section class="section">
		<article class="article4">판매자:<br>${vo.userid }</article>
		<article class="article4">시작 가격:<br>${vo.startPrice }</article>
<!-- 		<article class="article5"><input type="button" size="50" value="입찰버튼" onclick="buybutton('FrontServlet?command=auction_buy_form')"></article> -->
		<article class="article5">
		<form action="FrontServlet">
		<input type="hidden" name="command" value="auction_buy_form">
		<input type="hidden" name="boardNum" value="${vo.boardNum }">
		입찰금액을 입력해 주세요<input type="text" name="endprice" >
		<input type="submit" size="50" value="입찰버튼" onclick="return endpricecheck('${vo.endPrice}')">
		</form>
		</article>
	</section>

	<footer class="footer">
		<article class="article6">상품 상세 내용${vo.content}</article>
		<article class="article7">현재 입찰자<br>${vo.winner}</article>
	</footer>



</body>

</html>



