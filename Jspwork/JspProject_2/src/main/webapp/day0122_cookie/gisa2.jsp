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
          boolean blogin=false;
        
        	Cookie []cookies=request.getCookies();
        	if(cookies!=null)
        	{
        		for(int i=0;i<cookies.length;i++)
        		{
        			//loginok 라는 쿠키가 잇는지 검사
        			if(cookies[i].getName().equals("loginok")){
        				blogin=true;
        				break;
        			}
        		}
        	}
        %>
    <body>
                 
         <%
    if(blogin){
    //로그인이 된 상태
    %>
    <pre>
    윤석열 대통령이 내일 있을 헌법재판소 탄핵심판 4차 변론에 직접
    출석할 전망입니다.
	연합뉴스TV 취재에 따르면 윤 대통령의 법률대리인은 내일
	윤 대통령의 탄핵심판 출석을 확정하고 변론 전략을 짜고 있는 것으로
	전해졌습니다.
	앞서 윤 대통령 측은 "윤 대통령이 특별한 사정이 없는 한 탄핵심판에
	직접 출석할 것"이라고 밝혔습니다.
    </pre>
    <%}else{%>
    <script type="text/javascript">
    alert("먼저 로그인 해주세요");
    history.back(); //이전 페이지로 이동
    
    </script>
    <%}
    %>
    </body>
</html>