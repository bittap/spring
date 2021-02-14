<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="smartEditor/css/common.css" />
<link rel="stylesheet" type="text/css" href="smartEditor/css/common.css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('button').bind('click',move);
	});
	
	function move(){
		alert('test');
		location.href = "/main.do";
	};

</script>
</head>
<body>
	<div id="contents">
<h3>편지쓰기 완료</h3><ul class="navi">
<li class="home"><a href="../main" target="_top">홈</a></li>
</ul>
<ul class='helpbox' ><li style="font-size: large;">메일을성공적으로 보냈습니다.</li></ul>
<ul class='helpbox' style="width: 200px">
<c:choose>
	<c:when test="${chk == 1 }" >
		
		 <c:forEach items="${dto}" var="i">
		<li id="li" style="font-size: 10px;">받은이 : ${i.member_email }</li>
		</c:forEach> 
	</c:when>
	<c:otherwise>
		<li id="li" style="font-size: 10px;">받은이 : ${dto_one}</li>
	</c:otherwise>
</c:choose>
</ul>



			
			<div class="paging">
				<span class="pageing"> 
						<input type="button" value="확인">
				</span>

			</div>
</div>




</body>
</html>