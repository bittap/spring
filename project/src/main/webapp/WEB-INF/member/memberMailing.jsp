<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="smartEditor/css/common.css" />
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body>
<script type="text/javascript">
//<![CDATA[
function validSubmit() {
	var f = document.Frm;

	if (isEmpty(f.subject)) {
		alert("제목을 입력해 주세요.");
		f.subject.focus();
		return false;
	}

	if (getRadio(f.group) == "") {
		if (isEmpty(f.email)) {
			alert("이메일을 입력해 주세요.");
			f.email.focus();
			return false;
		}

		var emails = f.email.value.split(';');
		for (var i=0; i<emails.length; i++) {
			if (emails[i].trim() != "" && !checkEmail(emails[i].trim())) {
				alert("형식에 맞지 않는 이메일 주소가 존재합니다.\n\n이메일 주소를 정확하게 입력해 주세요.");
				f.email.focus();
				return false;
			}
		}
	}

	if (isEmpty(f.content)) {
		alert("내용을 입력해 주세요.");
		return false;
	}

	if (confirm("발송하시겠습니까?")) {
		f.submit();
	}
}
//]]>
</script>



<form name="Frm" action="member_mailing.do"  id = "frm" method="post"  >

		<table border="0" cellpadding="0" cellspacing="0" width="100%" class="t_form">
		<caption>메일 보내기 폼</caption>
		<colgroup><col width="130"><col width="*"></colgroup>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id = "title"  class="text_input" style="width:98%"/>
			</td>
		</tr>
		<tr>
			<th>보낼그룹</th>
			<td>
			
				<div><input type="radio" name="group" value="total" /> 회원전체 (<strong>${su}명</strong>)</div>
				<div class="mgt5"><input type="radio" name="group" value="" checked /> 이메일 입력</div>
				<div style="padding-left:25px"><input type="text" name="email" class="text_input" style="width:98%" /></div>
			</td>
		</tr>
		</table>

		<table border="0" cellpadding="0" cellspacing="0" width="100%" class="t_form">
		<tr>
			<td style="padding:0px;"><textarea id = "contents" name="contents"  style="width:100%; height:350px;"></textarea></td>
		</tr>
		</table>
</form>

<script type="text/javascript">

var oEditors = [];

 nhn.husky.EZCreator.createInIFrame({

 oAppRef: oEditors,

 elPlaceHolder: "contents", // html editor가 들어갈 textarea id 입니다.

 sSkinURI: "/project/resources/editor/SmartEditor2Skin.html",  // html editor가 skin url 입니다.

 fOnAppLoad: function () { 

        //수정모드를 구현할 때 사용할 부분입니다. 로딩이 끝난 후 값이 체워지게 하는 구현을 합니다.

         var title = localStorage.getItem("title");                      

         var contents = localStorage.getItem("contents");        //db에서 불러온 값은 여기에서 체워넣습니다.

         document.getElementById("title").value = title;     

         oEditors.getById["txtContent"].exec("PASTE_HTML", [contents]); //로딩이 끝나면 contents를 txtContent에 넣습니다.

     },

     fCreator: "createSEditor2"

 });

 

var onWrite = function(){
	
	 var contents = oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);  
	
	
	$('#frm').submit();
}



</script>



<script type="text/javascript" src="./quick_photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"> </script>
<div class="btn">
<input type="submit" id="search_btn"  value="확인" onclick="onWrite()"/>
</div>
</body>
</html>