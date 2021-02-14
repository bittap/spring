<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionList.jsp</title>
</head>
<body>
<%
	String smem_name = (String) session.getAttribute("mem_name");
	//application은 서버에 많은 부담 - 서버 다운
	//smem_name = application.getAttribute("mem_name");
	//권장사항 - forward일때만 유지됨
	//smem_name = request.getAttribute("mem_name");
	//디폴트-쓰레기-안쓴다
	// smem_name = page.getAttribute("mem_name");

	Integer sage = (Integer) session.getAttribute("mem_age");
	
	//out.print(smem_name);
	//out.print(sage);
%>
<%= smem_name %>
<br>
<%= sage %>
</body>
</html>