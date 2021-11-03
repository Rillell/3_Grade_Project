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
	request.setCharacterEncoding("EUC-KR");  //한글처리
	int num1 = Integer.parseInt(request.getParameter("num1"));
	//파라미터는 String형식이므로 계산을 위히서 int타입으로 변환
	int num2 = Integer.parseInt(request.getParameter("num2"));
	String op = request.getParameter("op");  //연산자
	
	int result=0; //계산 결과
%>
<h1>연산결과</h1>
<%  // 각 계산 처리 방식
	if(op.equals("+"))
		result = num1 + num2;
	else if(op.equals("-"))
		result = num1 - num2;
	else if(op.equals("X"))
		result = num1 * num2;
	else //나누기의 경우
		result = num1 / num2;
%>
<%=num1 %> <%=op%> <%=num2 %> = <%=result %>  <%-- num1 연산자 num2 = result --%>
</body>
</html>