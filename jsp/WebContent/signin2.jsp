<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String hobby = "";
		String[] arrHobby = request.getParameterValues("hobby");
//		out.println("선택하신 취미는 아래와 같습니다<br/>");
//		for(int i=0;i<arrHobby.length;i++) {
//			out.println((i+1) +". " + arrHobby[i]);
//			hobby += arrHobby[i] + ", ";
//		}
	%>
	입력하신 아이디 : <%=id %><br/>
	입력하신 비밀번호 : <%=pwd %><br/>
	입력하신 이름 : <%=name %><br/>
	선택하신 취미 : <%=hobby %><p/>
<!--
	<%
//		Map<String,String[]> map = request.getParameterMap();
//		out.println("Map에서 가져온 아이디 : " + map.get("id")[0] +"<br/>");
//		out.println("Map에서 가져온 비밀번호 : " + map.get("pwd")[0]+"<br/>");
//		out.println("Map에서 가져온 이름 : " + map.get("name")[0]+"<br/>");
//		for (int i = 0;i<arrHobby.length;i++) {
//		out.println("Map에서 가져온 취미 : " + (i+1) + ". " + map.get("hobby")[i]+"<br/>");
//		}
	%>
  -->
</body>
</html>