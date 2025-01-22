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
    보배 권희원 이민영 기자
    = 고위공직자범죄수사처는 22일 조사에 불응 중인 윤석열 대통령에 대해
    서울구치소를 찾아 강제구인과 현장조사를 시도할 예정이라고 밝혔다.

	조사의 실효성 면에서 강제구인보다는 구치소 내부에서 조사하는 방안에 
	무게를 싣는 모습이다.
	
	공수처 관계자는 이날 출입기자단 대상 브리핑에서 "강제구인이라기보다는
	강제구인과 현장조사를 포함한 조사를 위해서
	오늘 (시도) 할 예정"이라고 밝혔다.

	브리핑 직전인 오전 10시 20분께에는 공수처 차량이 경기도 의왕시 서울구
	치소 정문을 통과해 내부로 진입하는 모습이 포착됐다.
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