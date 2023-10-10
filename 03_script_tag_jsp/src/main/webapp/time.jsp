<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 선언부 --> 
<%!
	String s = "test";
	int count = 0;
	
	String getStr(String str){
		s += str;
		count++;
		return s;
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>TIME JSP</h1>
	<h2>수정 작업</h2>
	<!-- scriptlet 스크립틀릿 java code 실행문 -->
	
	<%
		java.text.SimpleDateFormat sdf
		= new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"
				);
		String date = sdf.format(System.currentTimeMillis());
	%>
	
	<h1>
	현재시간 : <%=date %> <br/>
	기본시간 : <%= new java.util.Date() %> <br/>
	</h1>
	<%= getStr("최기근 천재!!\t") + count %>
	
</body>
</html>