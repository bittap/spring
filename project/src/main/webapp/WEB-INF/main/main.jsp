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
	

</script>
</head>
<body>
	<div id="contents_main">

		<h3 class="main">내상점 통계분석</h3>

		<div class="analysis_area">

			<!-- //TODAY -->
			<div class="fl" style="width:49%">
				<p class="mgt20"><strong>TODAY</strong> REPORT (${month}월 0${day}일  ${day_of_the_week})</p>
				<table width="100%" class="t_list mgt5">
				<colgroup>
					<col width="50%" /><col width="*" />
				</colgroup>
				<thead>
				<tr>
					<th>주문(실제)</th>
					<th>실제매출현황</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>${today_order_count }건</td>
					<td>${today_price }원</td>
				</tr>
				</tbody>
				</table>
			</div>
			<!-- MONTH -->
			<div class="fr" style="width:49%;">
				<p class="mgt20"><strong>MONTH</strong> REPORT (${month-1}월)</p>
				<table width="100%" class="t_list mgt5">
				<colgroup>
					<col width="50%" /><col width="*" />
				</colgroup>
				<thead>
				<tr>
					<th>주문(실제)</th>
					<th>실제매출현황</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>${ before_order_count}건</td>
					<td>${before_price }원</td>
				</tr>
				</tbody>
				</table>
			</div>
			<!--// MONTH -->
		</div>


		<h3 class="main">월간 주문한 현황</h3>
		<table width="100%" class="t_list mgt5">
		<colgroup>
			<col width="15%" /><col width="*" /><col width="10%" /><col width="10%" />
		</colgroup>
		<thead>
		<tr>
			<th>주문자</th>
			<th>주문상품내역</th>
			<th>주문일</th>
			<th>주문수량</th>
		</tr>
		</thead>
		<tbody>
	<c:if test="${order_list != null}">
	<c:forEach items="${order_list}" var="order">	
		<tr>
			<td>${order.member_name }</td>
			<td>${order.proname }</td>
			<td>${order.order_date }</td>
			<td>${order.order_amount }</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${order_list == null}">
		<tr>
		<td colspan="4">월간 주문내역이 없습니다.</td>
		</tr>
	</c:if>

		</tbody>
		</table>


		<h3 class="main mgt20">월간 회원가입 현황</h3>
		<table width="100%" class="t_list mgt5">
		<colgroup>			<col width="*" /><col width="20%" /><col width="*" /><col width="10%" />
		</colgroup>
		<thead>
		<tr>
			<th>아이디</th>
			<th>성명</th>
			<th>이메일</th>
			<th>가입날짜</th>
		</tr>
		</thead>
		<tbody>
<c:if test="${member_list != null}">
	<c:forEach items="${member_list}" var="member">	
		<tr>
			<td>${member.member_id }</td>
			<td>${member.member_name }</td>
			<td>${member.member_email }</td>
			<td>${member.member_signDate }</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${member_list == null}">
		<tr>
		<td colspan="4">월간 회원가입 내역이 없습니다.</td>
		</tr>
	</c:if>
		</tbody>
		</table>

	</div>

</body>
</html>