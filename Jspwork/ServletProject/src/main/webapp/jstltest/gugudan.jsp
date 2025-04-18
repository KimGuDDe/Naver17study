<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
            
            .gugudan{
            	background-color: gray;
            	margin: 20px;
            	color: #fff;
            	
            }
            
            .title{
            	text-align: center;
            }
            
            
            
        </style>
    </head>
    
    <body>
    	<div class="gugudan">
    		<table class="table table-bordered tab" style="width: 100%;">
    			<caption class="title" align="top"><h3><b>[구구단]</b></h3></caption>
    			<thead style="text-align: center; background-color: silver;">
                <tr>
                    <c:forEach var="i" begin="1" end="9">
                        <th>${i}단</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody style="text-align: center; background-color: silver;">
                <c:forEach var="i" begin="1" end="9">
                    <tr>
                        <c:forEach var="j" begin="1" end="9">
                            <td>${j} x ${i} = ${j*i}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
    		</table>
    	</div>
    	
    </body>
</html>