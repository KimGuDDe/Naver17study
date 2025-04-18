<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Exo+2:ital,wght@0,100..900;1,100..900&family=Gaegu&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Sunflower:wght@300&family=Yesteryear&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <style>
            body * {
                font-family: 'Jua';                
            }
            
            header h1{
        	font-family: Yesteryear;
        	font-size : 5em;
        	height : 120px;
        	background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
            
            }
                        
            #login{
            	font-family: 'Jua'; 
            }
                      
            footer{
        	font-size : 0.7em;
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            position: relative; ;
            width: 100%;
            bottom: 0;
       		}	
            
        </style>
              
    </head>

    <body>
    <%
     String chksave=(String)session.getAttribute("chksave");
     String myid=(String)session.getAttribute("myid");
     
     if(chksave==null)
    	 myid="";
    %>
    <body style="background-image: url('../oneman_project_image/로그인세션블러.png'); background-repeat: no-repeat;
 		background-size: cover; background-position: center;">
    <header>
    <h1>Ncamp Interior Design</h1>
	</header>
	<br><br>	
    
    
 <div class="container">
 		
        <div class="row justify-content-end">
        	<img alt="로그인 화면 이미지" src="../oneman_project_image/로그인세션이미지.jpg"
        	style="width:500px;height: 500px; padding: 1rem; color: rgb(36, 255, 102);
  					filter: drop-shadow(0 0 3px rgba(255, 255, 255, 0.7));">        	
            <div id="login" class="col-md-6 login-form">
                <h2 class="text-center" style="font-size:3em;">로그인</h2>
                <form action="loginaction_inter.jsp" method="post">
                    <div class="form-group">
                        <label for="username">아이디 입력</label>
                        <input type="text" name="myid" class="form-control" placeholder="아이디" value="${sessionScope.myid}">
                    </div>
                    <div class="form-group">
                        <label for="password">비밀번호</label>
                        <input type="password" name="mypass" class="form-control" placeholder="비밀번호">
                    </div>    
                    <button type="submit" class="btn btn-custom btn-block">로그인</button>
                    <label><input type="checkbox" name="chksave" ${sessionScope.chksave == 'yes' ? 'checked' : ''}>아이디 저장</label>
                </form>
            </div>
        </div>
    </div>
    <br><br>
    <footer>
	<span>Copyright 2025 NCampDesig,Co., Ltd. All rights reserved.</span>
	</footer>
  </body>
</html>