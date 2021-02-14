<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${dto }" var="dto">
		<tr onMouseOver="this.style.backgroundColor='#FDFAE8'"
			onMouseOut="this.style.backgroundColor='#FFFFFF'">
			<td><input type="checkbox" name="cbList" class="cbList"
				value="37"></td>
			<td><a href="javascript:;" ezi="37"
				onClick="ezpop.member.open(event)">${dto.member_id }</a></td>
			<td>${dto.member_name }</td>

			<c:if test="${dto.member_sex=='남자' }">
				<td><img src='/project/resources/icon_man.gif' alt='' /></td>
			</c:if>
			<c:if test="${dto.member_sex=='여자' }">
				<td><img src='/project/resources/icon_woman.gif' alt='' /></td>
			</c:if>


			<c:set var="jumin" value="${dto.member_birthday}" />
			<!-- 현재년도 가져오기 -->
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<c:set var="sysYear">
				<fmt:formatDate value="${now}" pattern="yyyy" />
			</c:set>
			<c:set var="year" value="${fn:substring(sysYear,2,4)}" />

			<c:set var="splitJumin" value='${fn:split(jumin,"-")}' />
			<c:set var="backJuminFirst"
				value="${fn:substring(splitJumin[1],0,1)}" />
			<!-- 1900년도 사람일때 -->
			<c:if test="${backJuminFirst == '1' || backJuminFirst == '2'  }">
				<c:set value="${fn:substring(splitJumin[0],0,2)}" var="frontJumin" />
				<c:set var="age1" value="${100-frontJumin+1 }" />
				<!-- 계산한나이-->
				<c:set var="age" value="${age1+year}" />
				<td>${age}</td>
			</c:if>
			<!-- 2000년도 사람일때 -->
			<c:if test="${backJuminFirst == '3' || backJuminFirst == '4'  }">
				<c:set value="${fn:substring(splitJumin[0],0,2)}" var="frontJumin" />
				<!-- 계산한나이-->
				<c:set var="age" value="${year-frontJumin+1}" />
				<td>${age}</td>
			</c:if>


			<td>${dto.member_recentDate}</td>
			<td>${dto.member_purchaseAmount}</td>
			<td>${dto.member_signDate}</td>
		</tr>
	</c:forEach>

	<%-- <c:set value="${dto.size()}" var="asdf" ></c:set> --%>
	<input type="hidden" value="${su}" id="subal" />
	<input type="hidden" value="${page.totalPage}" id="totalPage" />
</body>
</html>