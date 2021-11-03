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
	int i = 0;
%>
지역변수 i = <%=++i %> <p>
멤버변수 memi = <%=++memi %>
<%!
	int memi = 0;
%>
</body>
</html>