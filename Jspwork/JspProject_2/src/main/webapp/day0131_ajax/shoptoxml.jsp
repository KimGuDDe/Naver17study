<?xml version="1.0" encoding="UTF-8"?>
<%@page import="test.data.ShopDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="test_data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="test_data.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
   <%
   ShopDto dao = new ShopDao();
   String search = request.getParameter("search");
   List<ShopDto> list = dao.getAllDatas(search);
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   
   for(ShopDto dto:list)
   {%>
      <Shop idx="<%=dto.getIdx() %>">
         <sangpum><%=dto.getSang() %></sangpum>
         <su><%=dto.getSu() %></su>
         <danga><%=dto.getDan() %></danga>
         <ipgoday><%=dto.getIpgoday() %></ipgoday>
      </Shop>
   <%}
   %>
</data>