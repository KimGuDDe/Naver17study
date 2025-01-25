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
	//파일이 업로드되는 실제 위치, 코드가 있는 위치가 아니라
	//톰켓 서버에 배포된 프로젝트 위치를 찾아야 한다
	String realFolder=getServletContext().getRealPath("/upload");
	//업로드할 파일의 크기
	int uploadSize=1024*1024*3;//3mb까지
	MultipartR multipartrequest = null;
	//tomcat9까지는 가능했지만 tomcat10부터는 jakartaEE가 적용된다
	//그래서 오류난다, 잘 안 쓰는 라이브러리
	try{
		/* multipartRequest = new multipartrequest(request, realfolder, uploadsize,
				"utf-8", new defaultfileReanmePolicy());
	}catch{excetion e)
{
	out.print("파일 업로드 오류발생"+e.getmessage());
}
} */
%>
<h5>실제 업로드 되는 위치</h5>
    <body>
        <h6><%=realFolder %></h6>
    </body>
</html>




