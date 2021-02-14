<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<%
	List<String> insaList = (List<String>)request.getAttribute("insaBean");
	for(int i=0; i<insaList.size();i++){
		String insa = insaList.get(i);
		out.print(insa+"<br>");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>insaList.jsp</title>
</head>
<body>
인사말 출력하기
</body>
</html>