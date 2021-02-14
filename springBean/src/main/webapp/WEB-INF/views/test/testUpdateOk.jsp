<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testUpdateOk.jsp[WEB-INF\views\test]</title>
</head>
<body>
글 수정 성공
<%
	List<String> nameList = (List<String>) request.getAttribute("nameList");
	for(String name:nameList) {
		out.print(name);
	}
%>
</body>
</html>