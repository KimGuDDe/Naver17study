<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shop.data.ShopDao"%>
<%@page import="shop.data.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1. num읽기
int num=Integer.parseInt(request.getParameter("num"));
//2. dao 선언
ShopDao dao=new ShopDao();
//3. num 에 해당하는 dto 얻기(dao 메소드 추가,메소드명 : getSangpum(int num))
dao.deleteShop(num);	

%>