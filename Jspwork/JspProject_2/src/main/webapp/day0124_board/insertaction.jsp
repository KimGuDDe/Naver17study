<%@page import="simpleboard.data.SimpleboardDao"%>
<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	//1.폼데이터 읽기
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
	//2.dto 선언 후 데이터 넣기(생성자료)
		SimpleBoardDto dto=new SimpleBoardDto(writer,subject,content);
	//3. dao선언
		SimpleboardDao dao = new SimpleboardDao();
	//4. insert 메서드 호출
		dao.insertBoard(dto);
	//5.boardlist.jsp 로 이동
		response.sendRedirect("./boardlist.jsp");
%> --%>

<!-- 클래스 생성(usebean) -->
<jsp:useBean id="dao" class="simpleboard.data.SimpleboardDao"/>
<jsp:useBean id="dto" class="simpleboard.data.SimpleBoardDto"/>
<!-- dto와 이름이 같은 폼태그를 읽어서  자동으로 읽어서 dto에 넣어준다  -->
<jsp:setProperty property="*" name="dto"/>
<%
	dao.insertBoard(dto);
	response.sendRedirect("./boardlist.jsp");
%>