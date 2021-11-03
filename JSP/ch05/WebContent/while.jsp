<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String msg = "Hello World!!!";
	
	int i = 0;
	
	while(i < 5){
%>
		<strong> <%=msg%> </strong> <br>
<% 
		i++;
	}
%>

</body>
</html>