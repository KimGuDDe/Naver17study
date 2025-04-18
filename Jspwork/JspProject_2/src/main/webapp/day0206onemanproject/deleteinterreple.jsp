<%@page import="inter.data.InterRepleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int idx=Integer.parseInt(request.getParameter("idx"));
	InterRepleDao dao = new InterRepleDao();
	dao.deleteInterReple(idx);
%>