<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원전용 페이지</title>
<script type="text/javascript" src="script/member.js"></script>
<script type="text/javascript">
function logout(){

	alert('정상적으로 로그아웃 되었습니다.');
	location.href='FrontServlet?command=logout';
}
</script>
<style type="text/css">

html, body {
   margin: 20px;
   padding: 0;
   width:100%;
   height: 100%;
   font-family: 함초롱돋움;
   
}


input[type=button], input[type=submit] {
    background-color: #005BAF;
    border: none;
    color: white;    
    padding: 4px 9px;
    text-decoration: none;
    margin: 2px 1px;
    cursor: pointer;
   font-family: 함초롱돋움;
   font-size: 15px;
}

</style>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h2 align="center" style="font-family: DX회전목마; font-size: 30px">회원전용 페이지</h2>
<form action="FrontServlet" name="frm">
   <input type="hidden" name="command" value="logout"> 
   <table>
      <tr>
         <td style="font-size : 25px">${loginUser.userid}(${loginUser.name})님 환영합니다.</td>
      </tr>
      <tr>
         <td>
         <a href="FrontServlet?command=my_info" target="mainView"><input type="button" value="내 정보"></a>
         <input type="button" value="쪽지" onclick="noteView('FrontServlet?command=note_main')"> 
         <a href="FrontServlet?command=free_board_list" target="mainView"><input type="button" value="로그아웃" 
                                    onclick="logout()"></a>
         </td>
      </tr>
      <tr>
         <td colspan="2" >${message}</td>
      </tr>
   </table>
</form>
</body>
</html>