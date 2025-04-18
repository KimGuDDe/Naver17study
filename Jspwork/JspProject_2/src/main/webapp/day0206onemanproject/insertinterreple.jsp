<%@page import="inter.data.InterRepleDao"%>
<%@page import="inter.data.InterDao"%>
<%@page import="inter.data.InterRepleDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	int star=Integer.parseInt(request.getParameter("star"));
	String message = request.getParameter("message");
	
	InterRepleDto dto = new InterRepleDto(num,star,message);
	
	InterRepleDao dao = new InterRepleDao();
	
	dao.insertInterReple(dto);
	
%>