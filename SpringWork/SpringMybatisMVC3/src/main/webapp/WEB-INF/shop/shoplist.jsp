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
            
            .shopbox figure{
            	float: left;
            	width: 150px;
            	text-align: center;
            	background-color: #ffe4e1;
            	border: 1px solid gray;
            	border-radius: 20px;
            	padding: 10px;
            	margin: 10px;            	
            }
            
            .shopbox figure img{
            	width: 130px;
            	height: 170px;
            	border: 1px solid gray;
            	border-radius: 20px;
            	cursor: pointer;            	
            }
            
            .shopbox figure figcaption{
            	text-align: center;
            }
            
            
        </style>
    </head>
	
    <body>
    <jsp:include page="../../layout/title.jsp"/>
    <div style="margin: 20px;width: 500px;">
    	<h5 class="alert alert-danger">총 ${totalCount }개의 상품이 있습니다
	    	<button type="button" class="btn btn-success btn-sm"
	    	style="float: right;"
	    	onclick="location.href='./addform'">상품추가</button>
    	</h5>
    </div>
    <div class="shopbox" style="margin: 20px;">
    	<c:forEach var="dto" items="${list}">
    		<figure>
    			<a href="./detail?num=${dto.num}">
    			<img src="${fronturl}/shop/${dto.mainPhoto}${backurl}"
    			onerror="this.src='../save/noimage.png'">
    			</a>
    			<figcaption style="padding: 5px;">
    				<h6>${dto.sangpum}</h6>
    				<h6>
    					<fmt:formatNumber value="${dto.sprice}" type="number"/>
    				</h6>
    			</figcaption>
    		</figure>
    	</c:forEach>
    </div>    
    </body>
</html>