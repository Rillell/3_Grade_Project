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
	request.setCharacterEncoding("euc-kr"); //�ѱ�ó��
	
	String msg = request.getParameter("msg");
	int number = Integer.parseInt(request.getParameter("number"));  //�Ķ���ʹ� ��Ʈ����.string�� ������ �ٲٱ�, Warpper
	
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