<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%="이건 jsp 파일입니다.<br/>" %>
<%="전 system.out.println이랑 상당히 비슷한 녀석이에요." %><br/>
<%
	out.println("out.println hihi<br/>");
	int a =1;
	int b=2;
	int result = a+b;
	out.println(a + " + " + b + " = " + result + "<br/>");
	
	int[] arrNum = new int[5];
	for(int i = 0; i <arrNum.length;i++) {			
		arrNum[i] = (i+1)*10;
	}

	for(int i = 0; i <arrNum.length;i++) {
		out.println("<br/>" +arrNum[i]);
	}

%>
</body>
</html>