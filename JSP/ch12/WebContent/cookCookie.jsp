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
��Ű�� ����ϴ�.<br>
���� Ȯ���ϱ� ���ؼ��� <a href="tasteCookie.jsp">�����</a>

</body>
</html>