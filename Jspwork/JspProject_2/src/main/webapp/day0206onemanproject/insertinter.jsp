<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="inter.data.InterDao"/>
<jsp:useBean id="dto" class="inter.data.InterDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	dao.insertInter(dto);
%>