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
	request.setCharacterEncoding("EUC-KR");  //�ѱ�ó��
	int num1 = Integer.parseInt(request.getParameter("num1"));
	//�Ķ���ʹ� String�����̹Ƿ� ����� ������ intŸ������ ��ȯ
	int num2 = Integer.parseInt(request.getParameter("num2"));
	String op = request.getParameter("op");  //������
	
	int result=0; //��� ���
%>
<h1>������</h1>
<%  // �� ��� ó�� ���
	if(op.equals("+"))
		result = num1 + num2;
	else if(op.equals("-"))
		result = num1 - num2;
	else if(op.equals("X"))
		result = num1 * num2;
	else //�������� ���
		result = num1 / num2;
%>
<%=num1 %> <%=op%> <%=num2 %> = <%=result %>  <%-- num1 ������ num2 = result --%>
</body>
</html>