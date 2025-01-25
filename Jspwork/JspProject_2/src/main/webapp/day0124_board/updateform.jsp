<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@page import="simpleboard.data.SimpleboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        </style>
    </head>
<%
	//1.num
	 int num = Integer.parseInt(request.getParameter("num"));
	//2. dao선언
	SimpleboardDao dao = new SimpleboardDao();
	//3. dto 얻기
	SimpleBoardDto dto = dao.getData(num);
%>
    <body>
        <div style="margin: 30px; width: 400px;">
		<form action="./updateaction.jsp" method="post">
		
		<!-- hidden -->
		<input type="hidden" name="num" value="<%=num %>">
		
		<table class="table table-bordered tabboard">
			<caption align = "top">
				<h5> <b> 글쓰기(수정)</b> </h5>
			</caption>
			<tr>
				<th width="100">작성자</th>
				<td>
					<input type="text" name="writer" class="form-control"
					autofocus="autofocus" required="required">
				</td>
			</tr>
			<tr>
				<th width="100">제목</th>
				<td>
					<input type="text" name="subject" class="form-control"
					required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 100%;height:150px;"
					class="form-control" name="content"
					required="required"></textarea> 
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-secondary">
					글수정</button>
										
					<button type="button" class="btn btn-outline-secondary"
					onclick="history.back()">취소</button>
				</td>
			</tr>
			
			</table>
		</form>
	
	</div>
    </body>
</html>