<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="adao" class="simpleboard.data.SimpleboardDao"/>
<jsp:useBean id="adto" class="simpleboard.data.SimpleAnswerDto"/>
<jsp:setProperty property="*" name="adto"/>

<%
	//insert 댓글
	adao.inserAnswer(adto);
	//상세보기 페이지로 이동
	response.sendRedirect("./contentdetail.jsp?num="+adao.getnum());

%>