<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="test.data.FoodDto"%>
<%@page import="java.util.List"%>
<%@page import="test.day0121.FoodDataList"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <style>
            body * {
                font-family: 'Jua';
            }
            .tab th{
            	background-color : pink;
            }

        </style>
    </head>
<%
		//FoodDataList 생성
		FoodDataList dataList=new FoodDataList();
		//list 전체 데이타 반환 받기
		List<FoodDto> list = dataList.getAllDatas();
	%>

    <body>
        <div style="margin: 20px">
        <table class="tab table table-bordered" style="width:600px">
        	<caption>
        		<h3><b>배달 음식 목록</b></h3>
        	</caption>
        	<tr>
        		<th width="50">번호</th>
        		<th width="200">apsb</th>
        		<th width="70">수량</th>
        		<th width="120">가격</th>
        		<th>배달날짜</th>
        	</tr>
        	<%
        	int no=0;
        	for(FoodDto dto:list)
        	{%>
        	<tr>
        		<td align="center"><%=++no %></td>
        		<td>
        		<img src="../image/food/<%=dto.getFoodPhoto()%>"
        		width="50" height="50" border="1"
        		class="rounded-circle" hspace="10">
        		<b><%=dto.getFoodName()%></b>
        		</td>
        		<td align="right"><%=dto.getSu()%>개</td>
        		<td align="right"><%=dto.getFoodPrice()%>원</td>
        		<td><%=dto.getFoodDay()%></td>
        	</tr>        		
        	<%}
        	%>
        </table>
        </div>
    </body>
</html>