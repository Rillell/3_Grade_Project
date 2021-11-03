<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String cookieName = "myCookie";
	Cookie cookie = new Cookie(cookieName, "apple");
	cookie.setMaxAge(60);
	cookie.setValue("Melnon");
	response.addCookie(cookie);
%>
쿠키를 만듭니다.<br>
쿠리를 확인하기 위해서는 <a href="tasteCookie.jsp">여기로</a>

</body>
</html>