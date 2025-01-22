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
    [이데일리 한광범 기자]
    윤석열 대통령 측이 헌법재판소 탄핵심판 변론 과정에서
    12.3 비상계엄 정당성을 주장하며 또다시 부정선거 음모론을 들고 나오자,
    중앙선거관리위원회가 이를 조목조목 반박했다.
	중앙선관위는 21일 홈페이지와 언론공지를 통해 A4 용지 9쪽 분량의
	‘대통령 탄핵심판 2차 변론 중 대통령 측의 부정선거 주장에 대한
	사실관계 설명’ 자료를 공개했다.
	선관위는 비상계엄 이후 윤 대통령이 공개적으로 부정선거 음모론을
	주장하며 논란이 확산되자, 관련 의혹 제기에 대해 적극적으로 반박에
	나서고 있는 상황이다.
	선관위 실무를 총괄하는 사무총장은 윤 대통령의 대학(서울대 법대)
	동기로서 사법연수원장을 지낸 김용빈 사무총장이다.
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