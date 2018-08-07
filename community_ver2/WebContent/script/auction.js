function buybutton(url){
	window.open(url, "_buy", "width=400, height=200");
}

function endpricecheck(price){
	if(document.frm.endprice.value<price){
		alert('현재 입찰가 보다 높게 입력해 주세요');
		return false;
	}else{
		return true;
	}
	
}

/*function inputcheck(){
	alert('입력이 완료되었습니다');
	window.close();
	window.opener.parent.location.href="FrontServlet?command=auction_view"
		return true;
}*/