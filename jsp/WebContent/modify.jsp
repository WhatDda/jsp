<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("user")==null){
	RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
	dis.forward(request, response);
	//forward 사용시 로그인 안된 상태에서 url에 modify.jsp 접속하면 url은 modify.jsp 이지만 화면은 login.jsp
}
Map<String, String> user = (Map)session.getAttribute("user");
%>
<form action="sigin.user" method="post">
<table border="1" cellspacing="0" cellpadding="0" width="400" align="center">
<tr>
	<td colspan="2"><p align="center"> = 회원 정보 수정 = </p></td>
</tr>
<tr>
	<td align="center">아이디</td>
	<td><input type="text" name="id" id="id" value="<%=user.get("id") %>" /></td>
</tr>
<tr>
	<td align="center">비밀번호</td>
	<td><input type="password" name="pwd" id="pwd" maxlength="100"/></td>
</tr>
<tr>
	<td align="center">이름</td>
	<td><input type="text" name="name" id="name" maxlength="100"  value="<%=user.get("name") %>"/></td>
<tr>
<tr>
	<td align="center">취미</td>
	<td>
		잠자기<input type="checkbox" name="hobby" value="잠자기" <%=user.get("hobby").indexOf("잠자기")!=-1?"checked":"" %>>
		게임<input type="checkbox" name="hobby" value="게임" <%=user.get("hobby").indexOf("게임")!=-1?"checked":"" %>>
		독서<input type="checkbox" name="hobby" value="독서" <%=user.get("hobby").indexOf("독서")!=-1?"checked":"" %>>
		음악<input type="checkbox" name="hobby" value="음악" <%=user.get("hobby").indexOf("음악")!=-1?"checked":"" %>>
	</td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="회원정보수정" /></td>
</tr> 
</table>
<input type="hidden" name="command" id="command" value="modify"/><br/>
</form>
</body>
</html>