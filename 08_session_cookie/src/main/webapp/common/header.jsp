<%@page import="java.util.List"%>
<%@page import="com.bitc.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Project</title>
</head>
<body>
	<!-- header.jsp -->
	<header>
		<%!
		String contextPath;		
	%>
		<%
		contextPath = request.getContextPath();
		out.println("contextPath : " + contextPath+"<br/>");
		
		// 요청 처리 완료 후 전달되는 message
		String msg = (String)request.getAttribute("msg");
		
		if(msg != null){
	%>
		<script>
		alert('<%=msg%>');	
	</script>
		<%	
		}
		
		// 로그인 된 사용자 정보 확인
		MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
		
		// 서버에 등록된 회원 목록
		List<MemberVO> memberList
			= (List<MemberVO>)application.getAttribute("memberList");
	%>
		<hr />
		<h3>브라우저에서 전달된 쿠키 정보</h3>
		<%
		if(loginMember == null){
			// 로그인 상태가 아닐 경우
			// 브라우저에서 전달되는 쿠키 정보 확인
			Cookie[] cookies = request.getCookies();
			a : for(Cookie c : cookies){
				// 로그인 상태 유지시 사용자 브라우저에 id를 name 값으로 uid 저장
				String name = c.getName();
				String value = c.getValue();
				if(name.equals("id") && memberList != null && !memberList.isEmpty()){
					for(MemberVO m : memberList){
						if(m.getUid().equals(value)){
							// uid 가 쿠키에 등록된 id와 일치하는 사용자 정보 검색 완료
							loginMember = m;
							session.setAttribute("loginMember",m);
							break a; 
						}
					} // end for
				} // end if
				long age = c.getMaxAge();
				out.println(name+":"+value+":"+age+"<br/>");
			} // end cookies for
		}
		
		String sessionId = session.getId();
		out.println("sessionid : " + sessionId);

	%>
		<hr />
		<a href="<%=contextPath%>">Main Page</a> |
		<% if(loginMember == null){ %>
		<!-- 로그인된 정보가 session에 존재하지않음 -->
		<a href="join.jsp">회원가입</a> | <a href="login.jsp">로그인</a>
		<% 
	}else{
		// 3E335BB54000945C29747B8280288143
	%>
		<!-- 로그인된 정보가 session에 존재 -->
		<%=loginMember.getUname() %>님 반갑습니다. | <a href="logout.jsp">로그아웃</a>
		<%
	}
	 %>
		<hr />
	</header>