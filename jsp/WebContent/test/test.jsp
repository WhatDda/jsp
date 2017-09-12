<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>Insert title here</title>
</head>
<script>
function callback(result){
		alert(result);
}

$(document).ready(function(){
	var param = {};
	param["command"] = "vendorcombo";
	param = "?param=" + JSON.stringify(param);
	param = encodeURI(param);
	var au = new AjaxUtil("","test.goods")
	au.changeCallBack(callback);
	au.send();
})
</script>
<body>
test.jsp파일입니다.
<%
response.sendRedirect("test2.jsp");
%>
</body>
</html>