<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	table{
		width : 200px;
		border : 1px solid black;
	}
	
	td{
		border : 1px solid black;
	}
</style>
</head>
<body>
<%
	String[] name = {"Java", "JSP", "Android", "Struts"};
%>
<table>
<%
	for(int i = 0; i<name.length; i++){
%>
		<tr>
			<td><%=i%></td>
			<td><%=name[i]%></td>
		</tr>	
<%
	}
%>
</table>
</body>
</html>