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
	String name = "Korea"; //변수입니다.
%>
<!-- html 주석입니다. -->
<%--  JSP 주석입니다. --%>
<!--  <%=name%> 주석에서도 동적인 변수 사용가능 -->
<%=name/*표현식*/ %> Fighting!!!
</body>
</html>