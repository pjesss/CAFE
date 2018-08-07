function open_buysalelistWin(url, name){
	window.open(url, name, "width=600, height=350");
}


function allCheck(){
	var allNum = document.getElementsByName("allNum");
	var arrCheck = document.getElementsByName("num")
	if(allNum[0].checked==true){
		for(i=0; i<arrCheck.length; i++){
			arrCheck[i].checked = true;
		}
	}else{
		for(i=0; i<arrCheck.length; i++){
			arrCheck[i].checked = false;
		}
	}
}
function selectCheck(){
	var arrCheck = document.getElementsByName("num")
	for(i=0;i<arrCheck.length;i++){
		if(arrCheck[i].checked == true){
			return true;
		}
	}
	alert('선택한 항목이 없습니다');
	return false;
}

