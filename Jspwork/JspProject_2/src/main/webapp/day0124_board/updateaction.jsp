<%@page import="simpleboard.data.SimpleboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//자바 빈즈를 이용해서 처리하기
	//useBean으로 dao,dto 선언하고 setProperty로 전체 데이터 읽기
	
	//dao의 updateBoard 호출
	int num = Integer.parseInt(request.getParameter("num"));
	SimpleboardDao dao = new SimpleboardDao();
	dao.updateBoard(num);
	//상세보기로 이동
	response.sendRedirect("./borderlist.jsp");
%>