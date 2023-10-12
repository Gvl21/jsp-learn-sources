<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVO" %>
<%@ page import="java.sql.*" %>
<%@ include file="connection.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinCheck.jsp</title>
</head>
<body>
	<% 
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String mAge = request.getParameter("age");
		
		int age = Integer.parseInt(mAge);
		
		PreparedStatement pstmt = null;
		
		try{
			pstmt = conn.prepareStatement(
					"INSERT INTO test_member(id, pass, name, addr, phone, gender, age) VALUES(?, ?, ?, ?, ?, ?, ?)"
					); 
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, addr);
			pstmt.setString(5, phone);
			pstmt.setString(6, gender);
			pstmt.setInt(7, age);
			int result = pstmt.executeUpdate();
			if(result > 0){
				out.println("회원정보 등록 완료");
			} else{
				out.println("회원정보 등록 실패");
			}
				out.println("-" + result);
		} catch(SQLException e){
			out.println("<h3>DB 작업 수행실패</h3>");
			out.println("<h3>" + e.toString() + "</h3>");
		} finally{
			DBCPUtil.close(pstmt, conn);
		}
	%>
	<br/>
	<a href="index.jsp">메인으로</a>
	 %>
	
</body>
</html>