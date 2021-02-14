<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/button.css" />
<style type="text/css">
.ui-datepicker {
	font-size: 8px; 1
	width: 160px;
}

.ui-datepicker select.ui-datepicker-month {
	width: 20%;
	font-size: 5px;
}

.ui-datepicker select.ui-datepicker-year {
	width: 30%;
	font-size: 5px;
}
</style>
<script>
	$(function() {
		$.datepicker.regional['ko'] = {
			prevText : '이전달',
			nextText : '다음달',
			currentText : '오늘',
			closeText : '닫기',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			dateFormat : 'yy-mm-dd',
			firstDay : 0,
			isRTL : false,
			showMonthAfterYear : true,
			yearSuffix : '년'
		};
		$.datepicker.setDefaults($.datepicker.regional['ko']);

		$(".cal_search").datepicker({

			showOn : "button",

			buttonImage : "/project/resources/images/btn_open.gif",

			buttonImageOnly : true,

			buttonText : "Select date"

		});
	});
</script>
<script type="text/javascript">
	var inperiod1 = {

		//전체
		input : function(member_signDate1, member_signDate2, chk, minus) {

			//전체날짜	
			if (chk == null) {
				$('#member_signDate1').val("");
				$('#member_signDate2').val("");
			}//오늘
			else if (minus == null) {
				$('#member_signDate1').val(
						$.datepicker.formatDate($.datepicker.ATOM, new Date()));
				$('#member_signDate2').val(
						$.datepicker.formatDate($.datepicker.ATOM, new Date()));
			} else {
				var minusDate = new Date();
				minusDate.setDate(minusDate.getDate() + minus);
				var member_signDate1 = $.datepicker.formatDate("yy-mm-dd",
						minusDate);
				$('#member_signDate1').val(member_signDate1);
				$('#member_signDate2').val(
						$.datepicker.formatDate($.datepicker.ATOM, new Date()));
			}

		}

	}

	var inperiod2 = {

		//전체
		input : function(member_recentDate1, member_recentDate2, chk, minus) {
				
			//전체날짜	
			if (chk == null) {
				$('#member_recentDate1').val("");
				$('#member_recentDate2').val("");
			}//오늘
			else if (minus == null) {
				$('#member_recentDate1').val(
						$.datepicker.formatDate($.datepicker.ATOM, new Date()));
				$('#member_recentDate2').val(
						$.datepicker.formatDate($.datepicker.ATOM, new Date()));
			} else {
				var minusDate = new Date();
				minusDate.setDate(minusDate.getDate() + minus);
				var member_recentDate1 = $.datepicker
						.formatDate("yy-mm-dd", minusDate);
				$('#member_recentDate1').val(member_recentDate1);
				$('#member_recentDate2').val(
						$.datepicker.formatDate($.datepicker.ATOM, new Date()));
			}

		}

	}

	function toCurrency(chk) {

		if (chk.id == "member_purchaseAmount1") {
			patt1 = /[^0-9]/;
			data1 = $('#member_purchaseAmount1').val();
			if (patt1.test(data1)) {
				$('#member_purchaseAmount1').val("");
			} else {

			}

		}

		if (chk.id == "member_purchaseAmount2") {
			patt2 = /[^0-9]/;
			data2 = $('#member_purchaseAmount2').val();
			if (patt2.test(data2)) {
				$('#member_purchaseAmount2').val("");
			} else {

			}
		}

	}
</script>

<script type="text/javascript">
	//체크박스 모두 선택 모두 해제
	$(document).ready(function() {
		$('#cbListAll').bind('click', function() {
			if ($(this).is(":checked")) {
				$('.cbList').prop('checked', true);
			} else {
				$('.cbList').prop('checked', false);
			}

		});
	});
</script>
<script type="text/javascript">
	//버튼을 클릭했을 떄
	$(document).ready(function() {

		$('#search_btn').bind('click', process);


	});
	


	function process() {
		//다시 검색버튼을 누르면 초기화해준다.
		 $('#check').val(0);
		 $('.member_signDate1').val("");
		 $('.member_signDate2').val("");
		 $('.member_recentDate').val("");
		 $('.member_recentDate').val("");
		 $('.member_purchaseAmount1').val("0");
		 $('.member_purchaseAmount2').val("0");
		 $('.select').val("0");
		 $('.select_result').val("");
		 $('.psize').val("0");
		 $('.sort').val("");
		 $('.currentPage').val("");
		 
		 
		 
		

		var number = document.getElementById("sel_search");
		//검색을 눌렀을때는 무조건 페이지가 1이다.
		var pageNumber = 1

		$.ajax({
			type : 'GET',
			dataType : 'text',
			url : 'member_List.do?member_signDate1='
					+ $('#member_signDate1').val() + '&member_signDate2='
					+ $('#member_signDate2').val() + '&member_recentDate1='
					+ $('#member_recentDate1').val() + '&member_recentDate2='
					+ $('#member_recentDate2').val() + '&member_purchaseAmount1='
					+ $('#member_purchaseAmount1').val()
					+ '&member_purchaseAmount2='
					+ $('#member_purchaseAmount2').val() + '&select='
					+ number.selectedIndex + '&select_result='
					+ $('#sel_result').val() + '&psize=5' 
					+ '&psort=member_signDate' + '&pageNumber='
					+ pageNumber,
			success : function(res) {

				$('#tbody_result').html(res);
				$('.red').html($('#subal').val());
				//페이지값 받아와서 인풋 히든에 넣어주기
				var page = $('#totalPage').val();
				var t = "";
				for (var i = 1; i <= page; i++) {
					t += '<strong onclick="pageFunction(this)" id ="'+i+'">'+ i+" "+'</strong></a>';

				}
				$(".pageing").html(t);
				$('#1').css('color','red');

			}
		});
		//갯수와 정렬을 초기화
		$('#psize1').prop('selected','selected');
		$('#psort1').prop('selected','selected');
		
	};
	//줄씩보기를 바꿧을때, 정렬을 바꿧을때
	function process1() {
		if ($('#subal').val() != null) {
			var number = document.getElementById("sel_search");
			var page = 1;
			$.ajax({
				type : 'GET',
				dataType : 'text',
				url : 'member_List.do?member_signDate1='
						+ $('#member_signDate1').val() + '&member_signDate2='
						+ $('#member_signDate2').val() + '&member_recentDate1='
						+ $('#member_recentDate1').val() + '&member_recentDate2='
						+ $('#member_recentDate2').val() + '&member_purchaseAmount1='
						+ $('#member_purchaseAmount1').val()
						+ '&member_purchaseAmount2='
						+ $('#member_purchaseAmount2').val() + '&select='
						+ number.selectedIndex + '&select_result='
						+ $('#sel_result').val() + '&psize='
						+ $('#psize').val() + '&psort=' + $('#psort').val()
						+ '&pageNumber=' + page,
				success : function(res) {
					//alert(res)
					$('#tbody_result').html(res);
					$('.red').html($('#subal').val());
					//페이지값 받아와서 인풋 히든에 넣어주기
					var page = $('#totalPage').val();
					var t = "";
					for (var i = 1; i <= page; i++) {
						t += '<strong onclick="pageFunction(this)" id ="'+i+'">'+ i+" "+'</strong></a>';

					}
					$(".pageing").html(t);
					$('#1').css('color','red');
				}
			});
		}
	};
	
	//페이지를 눌렀을떄
	function pageFunction(pageNumber){
		var page = pageNumber.id;
		var number = document.getElementById("sel_search");
		
		//ajax로 이미 값이 등록되있는걸 가지고 갈때
		if($('#check').val() != 1){	
		location.href = "member_List1.do?member_signDate1="
			+ $('#member_signDate1').val()
			+ '&member_signDate2='
			+ $('#member_signDate2').val()
			+ '&member_recentDate1=' + $('#member_recentDate1').val()
			+ '&member_recentDate2=' + $('#member_recentDate2').val()
			+ '&member_purchaseAmount1='
			+ $('#member_purchaseAmount1').val()
			+ '&member_purchaseAmount2='
			+ $('#member_purchaseAmount2').val()
			+ '&select=' + number.selectedIndex
			+ '&select_result=' + $('#sel_result').val()
			+ '&psize=' + $('#psize').val() + '&psort='
			+ $('#psort').val() + '&pageNumber=' + page;
		}else{
			location.href = "member_List1.do?member_signDate1="
				+ $('.member_signDate1').val()
				+ '&member_signDate2='
				+ $('.member_signDate2').val()
				+ '&member_recentDate1=' + $('.member_recentDate1').val()
				+ '&member_recentDate2=' + $('.member_recentDate2').val()
				+ '&member_purchaseAmount1='
				+ $('.member_purchaseAmount1').val()
				+ '&member_purchaseAmount2='
				+ $('.member_purchaseAmount2').val()
				+ '&select=' + $('.select').val()
				+ '&select_result=' + $('.sel_result').val()
				+ '&psize=' + $('.psize').val() + '&psort='
				+ $('.psort').val() + '&pageNumber=' + page;
		}
		
	};
</script>

</head>
<body>

	<!-- 전체 div -->
	<div style="width: 1200px;">
		<ul class='helpbox'>
			<li>다음은 사이트에 가입한 회원목록 입니다.</li>
			<li><strong>총구매금액</strong> 산출 = (판매가 + 옵션가) × 수량</li>
			<li>배송비 및 적립금, 쿠폰 등의 할인내역은 금액에 포함되지 않습니다.</li>
		</ul>

		<!-- 검색 폼 ###################################################################### -->
		<form name="sFrm" id="sFrm" method="get"
			onSubmit="return validSearch(this)">
			<input type="hidden" name="psort" value="regdate" /> <input
				type="hidden" name="psize" value="10" />

			<table cellspacing="0" cellpadding="0" border="0" width="100%"
				class="t_form">
				<!-- <caption>회원 검색 폼</caption> -->
				<colgroup>
					<col width="130">
					<col width="*">
				</colgroup>
				<tr>
					<th>가입일</th>
					<td>
						<div>
							<input type="text" class="cal_search" name="member_signDate1"
								id="member_signDate1" value="" maxlength="10" class="text_input"
								style="width: 70px" /> ~ <input type="text"
								id="member_signDate2" class="cal_search" name="member_signDate2"
								value="" maxlength="10" class="text_input" style="width: 70px" />
							직접 입력시에는 “2007-01-01” 형식으로 입력해주세요.
						</div>
						<div class="mgt5">
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2')">전체</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2', 'd')">오늘</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2', 'd', -1)">어제</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2', 'd', -3)">3일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2', 'd', -7)">7일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2', 'd', -10)">10일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2', 'd', -20)">20일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod1.input('member_signDate1', 'member_signDate2', 'd', -30)">30일간</button></span>
						</div>
					</td>
				</tr>
				<tr>
					<th>최근접속일</th>
					<td>
						<div>
							<input type="text" class="cal_search" id="member_recentDate1"
								name="member_recentDate1" value="" maxlength="10" style="width: 70px" />
							~ <input type="text" class="cal_search" id="member_recentDate2"
								name="member_recentDate2" value="" maxlength="10" style="width: 70px" />
							직접 입력시에는 “2007-01-01” 형식으로 입력해주세요.
						</div>
						<div class="mgt5">
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2')">전체</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2', 'd')">오늘</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2', 'd', -1)">어제</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2', 'd', -3)">3일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2', 'd', -7)">7일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2', 'd', -10)">10일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2', 'd', -20)">20일간</button></span>
							<span class="button small"><button type="button"
									onClick="inperiod2.input('member_recentDate1', 'member_recentDate2', 'd', -30)">30일간</button></span>
						</div>
					</td>
				</tr>
				<tr>
					<th>총구매금액</th>
					<td><input type="text" name="member_purchaseAmount1"
						id="member_purchaseAmount1" value="" class="text_input"
						style="width: 100px" onKeyUp="toCurrency(this)" /> 원 ~ <input
						type="text" id="member_purchaseAmount2"
						name="member_purchaseAmount2" value="" class="text_input"
						style="width: 100px" onKeyUp="toCurrency(this)" /> 원</td>
				</tr>
				<tr>
					<th>직접검색</th>
					<td><select id='sel_search' name='sel_search'><option
								value="all" selected="selected">전체</option>
							<option value='member_id'>회원아이디</option>
							<option value='member_name'>회원명</option>
							<option value='member_homeNumber'>전화번호</option>
							<option value='member_telNumber'>휴대폰번호</option>
							<option value='member_email'>이메일</option></select> <input type="text"
						id="sel_result" name="sel_result" class="text_input"
						style="width: 300px"> <input type="button" id="search_btn"
						value="검색" /> <span>※ 전체를 검색하시려면 어떠한 텍스트박스에도 값이 있으면 안됩니다.
					</span></td>
				</tr>
			</table>

		</form>
		<!-- 검색 폼 : 끝 ###################################################################### -->

		<!--  목록 폼 -->
		<form name="Frm" method="post">
			<input type="hidden" name="mode" /> <input type="hidden" name="no" />
			<input type="hidden" name="id" /> <input type="hidden" name="params"
				value="sregdts=^sregdte=^svisitdts=^svisitdte=^slevel=0^sgender=^sbuyprice=^ebuyprice=^scmoney=^ecmoney=^skey=^sword=^psort=regdate^psize=10^page=" />

			<div class="section_head">
				<c:if test="${exist != 1 }">
				<h4>
					총 <strong class="red"></strong> 명의 회원이 조회 되었습니다.
				</h4>
				</c:if>
				<c:if test="${exist == 1 }">
				<h4>
					총 <strong class="red">${su}</strong> 명의 회원이 조회 되었습니다.
				</h4>
				</c:if>
				<div>
					<select id='psize' name='psize' onchange="process1(this)"><option value='5' id="psize1" >5줄씩보기</option>
						<option value='10'>10줄씩보기</option>
						<option value='15'>15줄씩보기</option></select> <select id='psort' name='psort' onchange="process1(this)"><option
							value='member_signDate' id = "psort" >회원가입일</option>
						<option value='member_purchaseAmount'>총구매금액</option>
						<option value='member_name'>이름순</option>
					</select>

				</div>
			</div>



			<table border="0" cellpadding="0" cellspacing="0" width="100%"
				class="t_list">
				<!-- <caption>가입한 회원 목록</caption> -->
				<thead>
					<tr>
						<th><input type="checkbox" name="cbListAll" id="cbListAll" /></th>
						<th>아이디</th>
						<th>성명</th>
						<th>성별</th>
						<th>나이</th>
						<th>최근<br />접속일
						</th>
						<th>총구매금액</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody id="tbody_result">
				<!-- exist가 1이면 MemberDaoController1을 걸친것이다. -->
					<c:if test="${exist == 1 }">
						<!-- 줄씩보기를 바꿧을 때 가능하게 해주는것 -->
						<input type="hidden" value="${su}" id="subal" />
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
									<c:set value="${fn:substring(splitJumin[0],0,2)}"
										var="frontJumin" />
									<c:set var="age1" value="${100-frontJumin+1 }" />
									<!-- 계산한나이-->
									<c:set var="age" value="${age1+year}" />
									<td>${age}</td>
								</c:if>
								<!-- 2000년도 사람일때 -->
								<c:if test="${backJuminFirst == '3' || backJuminFirst == '4'  }">
									<c:set value="${fn:substring(splitJumin[0],0,2)}"
										var="frontJumin" />
									<!-- 계산한나이-->
									<c:set var="age" value="${year-frontJumin+1}" />
									<td>${age}</td>
								</c:if>

								<td>${dto.member_recentDate}</td>
								<td>${dto.member_purchaseAmount}</td>
								<td>${dto.member_signDate}</td>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>
			</table>

			<div class="paging">
				<span class="pageing"> <c:choose>
						<c:when test="${exist != 1}">
							<a href="#"><strong id="memberBuyList_page" style="color: red" >1</strong></a>
						</c:when>
						<c:otherwise>
						 <c:forEach begin="1" end="${page.totalPage}" step="1" varStatus="status" >
							<c:choose>	
								<c:when test="${page.currentPage == status.current }">
									<strong onclick="pageFunction(this)" id ="${status.current}" style="color: red" >${status.current}</strong> 
								</c:when>
								<c:otherwise>
									<strong onclick="pageFunction(this)" id ="${status.current}" >${status.current}</strong> 
								</c:otherwise>
							</c:choose>
						
						
						
					</c:forEach> 
						</c:otherwise>
					</c:choose>
				</span>

			</div>


			<div class="btn_right">
				<span class="button large black"><button type="button"
						onClick="delList()">선택삭제</button></span>
			</div>

		</form>
	</div>

	<c:if test="${exist == 1 }">
	<!-- memberDAO1을 걸쳤는지 확인 하기 위한 값 -->
		<input type="hidden" id="check" value="1" />
		
		<!-- 값을 유지해주기 위해 필요한 값 -->
		<input type="hidden" class="member_signDate1" value="${page.member_signDate1}" />
		<input type="hidden" class="member_signDate2" value="${page.member_signDate2}" />
	 	<input type="hidden" class="member_recentDate1" value="${page.member_recentDate1}" />
		<input type="hidden" class="member_recentDate2" value="${page.member_recentDate2}" /> 
		<input type="hidden" class="member_purchaseAmount1" value="${page.member_purchaseAmount1}" />
		<input type="hidden" class="member_purchaseAmount2" value="${page.member_purchaseAmount2}" />
		<input type="hidden" class="select" value="${page.select}" />
		<input type="hidden" class="select_result" value="${page.select_result}" />
		<input type="hidden" class="psize" value="${page.size }" />
		<input type="hidden" class="sort" value="${page.sort }" />
		
		<!-- 현재 페이지 값을 받기위해 필요한 값 -->
		<input type="hidden" class="currentPage" value="${page.currentPage }" />
	</c:if>



</body>
</html>