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
	request.setCharacterEncoding("EUC-KR"); //�ѱ� ó��
	int num = Integer.parseInt(request.getParameter("num")); //�޾ƿ� ����Ÿ���� ���� Ÿ������ ��ȯ
%>	
	<h1>������: <%=num%>��</h1>  <%-- �޾ƿ� num�� ��� --%>
<% 	
	for(int j=1; j<10; j++){  //j�� �ܿ� �������� ��, 1~9�ݺ�
%>
		<%=num %> * <%=j %> = <%=num*j %> <br>   <%-- num * j = ����� ���·� ��� --%>
<% 
	}

%>
</body>
</html>