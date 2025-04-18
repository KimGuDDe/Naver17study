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
            
            .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container label {
            font-weight: bold;
        }
        .form-container input, .form-container textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #0056b3;
        }
            
        </style>
    </head>
	
    <body>
     <div class="form-container">
        <h2>상품 수정</h2>
        <form action="./update" method="post">
            <input type="hidden" name="num" value="${dto.num}">        
            <label for="sangpum">상품명</label>
            <input type="text" id="sangpum" name="sangpum" value="${dto.sangpum}" required>
            <label for="scolor">색상</label>
            <input type="text" id="scolor" name="scolor" value="${dto.scolor}" required>
            <label for="sprice">가격</label>
            <input type="number" id="sprice" name="sprice" value="${dto.sprice}" required>
            <label for="scnt">수량</label>
            <input type="number" id="scnt" name="scnt" value="${dto.scnt}" required>            
            <label for="ipgoday">입고일</label>
            <input type="date" id="ipgoday" name="ipgoday" value="${dto.ipgoday}" required>
            <button type="submit" style="padding: 5px;">수정 완료</button>
            <br><br>
            <button type="button" style="padding: 5px;" onclick="history.back()">	이전으로</button>        
        </form>
    </div>
    </body>
</html>