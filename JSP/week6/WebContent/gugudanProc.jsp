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
	request.setCharacterEncoding("EUC-KR"); //한글 처리
	int num = Integer.parseInt(request.getParameter("num")); //받아올 문자타입을 정수 타입으로 변환
%>	
	<h1>구구단: <%=num%>단</h1>  <%-- 받아온 num값 출력 --%>
<% 	
	for(int j=1; j<10; j++){  //j는 단에 곱해지는 수, 1~9반복
%>
		<%=num %> * <%=j %> = <%=num*j %> <br>   <%-- num * j = 결과값 형태로 출력 --%>
<% 
	}

%>
</body>
</html>