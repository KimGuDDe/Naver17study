<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String amho = request.getParameter("amho");
	//암호가 bitcamp 가 맞다면 쿠키 생성(이름은 loginok)
	if(amho.equals("bitcamp")){
		Cookie cookie= new Cookie("loginok",amho);
		//name은 loginok,value는 아무거나 저장
		cookie.setPath("/");//저장위치
		cookie.setMaxAge(10);//쿠키유지시간,초단위
		response.addCookie(cookie);//브라우저에 쿠키 추가
		response.sendRedirect("./cookiemain.jsp");//메인 페이지로 이동
	}else{%>
		<script>
			alert("암호가 안 맞아요");
			history.back();
		</script>
	<%}
%>
