<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String chksave=(String)session.getAttribute("chksave");

	session.removeAttribute("loginok");
		
	//메인 페이지로 이동
	response.sendRedirect("./sessionmain_inter.jsp");
%>