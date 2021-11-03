<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>while Example</h1>
<%
	request.setCharacterEncoding("euc-kr"); //한글처리
	
	String msg = request.getParameter("msg");
	int number = Integer.parseInt(request.getParameter("number"));  //파라미터는 스트링임.string을 정수로 바꾸기, Warpper
	
	int count = 0;
	while(count < number){
%>
		<%=msg %><br>
<% 
		count++;
	}
%>
</body>
</html>