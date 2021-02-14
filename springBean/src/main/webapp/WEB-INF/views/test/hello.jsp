<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp[WEB-INF\views\test\]</title>
</head>
<body>
<%
	List<String> nameList = (List<String>) request.getAttribute("nameList2");
	for(String name:nameList) {
		out.print(name);
	}
%>
</body>
</html>