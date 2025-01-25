<%@page import="java.util.List"%>
<%@page import="simpleboard.data.SimpleAnswerDao"%>
<%@page import="simpleboard.data.SimpleAnswerDto"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style>
body * {
	font-family: 'Jua';
}

.btn {
	width: 90px;
}

.day {
	color: #ccc;
	font-size: 0.8em;
	float: right;
}

.answerlist{
	margin-bottom: 10px;
	margin-left: 10px;
}

.answerdel{
	color: gray;
	margin-left: 5px;
	cursur : pointer;
}
</style>
</head>
<%
	//1 num 읽기
		int num=Integer.parseInt(request.getParameter("num"));
	//2 dao 선언
		SimpleboardDao dao= new SimpleboardDao();
	//3. 조회수 증가 메서드 호출
		dao.updateReadCount(num);
	//4. num에 해당하는 dto 얻기
		SimpleBoardDto dto= dao.getData(num);
		
	//5. 날짜 양식(yyyy.MM.dd HH:mm)
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
	
	//6.adao 선언
	SimpleAnswerDao adao = new SimpleAnswerDao();
	//7.num에 해당하는 alist 가져오기
	List<SimpleAnswerDto> alist = adao.getAnswerByNum(num);


%>
<body>
	<div style="margin: 20px; width: 500px;">
		<table class="table">
			<caption align="top">
				<h2>
					<b> <%= dto.getSubject() %></b>
				</h2>
			</caption>
			<tr>
				<td><b>작성자:<%=dto.getWriter() %></b> <span class="day"><%=sdf.format(dto.getWriteday()) %></span>
				</td>
			</tr>
			<tr>
				<td>
				<span>조회 <%=dto.getReadcount() %></span>
				<br>
				<br>
				<!-- 줄넘김 1 -->
					<div>
						<%= dto.getContent().replace("\n", "<br>") %>
					</div>
					
					<!-- 줄넘기 2  -->
					<pre><%=dto.getContent() %></pre>
					</td>
			</tr>
			<tr>
				<td>
					<div class="answerlist">댓글 출력할 곳</div>
					
					<form action="./answeraction.jsp" method="post">
					<input type="hidden" name="num" value="<%=num%>">
					<div class="input-group">
					<input type="text" class="form-control"
					name="nickname" style="width: 120px;"
					placeholder="닉네임" required="required">
					&nbsp;&nbsp;
					<input type="text" class="form-control"
					name="nickname" style="width: 250px;"
					placeholder="댓글내용" required="required">
					&nbsp;&nbsp;
					<button type="submit" class="btn btn-sm btn-info">등록</button>
					</div>
					</form>
				</td>
			</tr>
			<tr align="center">
				<button type="button" class="btn btn-sm btn-outlin-success"
				onclick="location.href='./boardform.jsp'">글쓰기</button>
				
				<button type="button" class="btn btn-sm btn-outlin-success"
				onclick="location.href='./boardlist.jsp'">목록</button>
				
				<button type="button" class="btn btn-sm btn-outlin-success"
				onclick="location.href='./updateform.jsp?num=<%=dto.getNum() %>'">수정</button>
				
				<button type="button" class="btn btn-sm btn-outlin-success"
				onclick="delfun(<%=dto.getNum() %>)">삭제</button>
				
				<script type="text/javascript">
				 function delfun(num) {
					let ans=confirm("해당 게시글을 삭제합니다");
					if(ans){
						location.href="./boraddelete.jsp?num="+num
					}
				}
				</script>
			
			</tr>
		</table>
	</div>
</body>
</html>