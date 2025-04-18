<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="inter.data.InterDto"%>
<%@page import="java.util.List"%>
<%@page import="inter.data.InterDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 파라미터로 정렬 순서를 가져옴
    int order = Integer.parseInt(request.getParameter("order"));
    InterDao dao = new InterDao();
    List<InterDto> list = dao.getAllInters(order);

    // JSON 배열 생성
    JSONArray arr = new JSONArray();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    // 리스트를 순회하며 JSON 객체 생성
    for (InterDto dto : list) {
        JSONObject ob = new JSONObject();
        ob.put("num", dto.getNum()); // 숫자는 그대로 출력
        ob.put("iname", dto.getIname() != null ? dto.getIname() : ""); // null 대신 빈 문자열
        ob.put("imessage", dto.getImessage() != null ? dto.getImessage() : "");
        ob.put("writeday", dto.getWriteday() != null ? sdf.format(dto.getWriteday()) : ""); // 날짜 포맷팅

        arr.add(ob); // JSON 배열에 추가
    }    
%>
<%=arr%>
