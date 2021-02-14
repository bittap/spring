<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieList.jsp</title>
</head>
<body>
	<%
	/* 
		쿠키에 담긴 정보를 클라이언트로 반드시 내려 보낸다.
		response.addCookie(c1);
		jsp나 서블릿에서 클라이언트에 text파일로 관리되고 있는 쿠키정보를 꺼내려면 요청해야 함
		request.getCookies();
	*/
		Cookie[] cs = request.getCookies();
		for(int i =0; i<cs.length; i++) {
			String cName = cs[i].getName();
			out.print("쿠키 이름 : " + cName);
			out.print(", 쿠키  값 : " + cs[i].getValue());
			out.print("<br>");
		}
	%>
</body>
</html>