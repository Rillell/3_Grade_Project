<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	table{
		border : 1px solid black;
		border-collapse :collapse;   <%--�׵θ��� ��ø�� ��� ��ħ--%>
		width:300px;
	}	
	td{
		border : 1px solid black;
	}	
</style>
</head>
<body>
<% 
	request.setCharacterEncoding("EUC-KR"); //�ѱ�ó��
	String name = request.getParameter("name"); //�̸�
	String gender = request.getParameter("gender"); //����
	String major = request.getParameter("major"); //�а�
	String[] hobby = request.getParameterValues("hobby"); //�迭�� �Ͽ� üũ�ڽ� ������ ������ �޾ƿü� �ֵ���
%>

<h2><%=name %>���� �Է��� �����Դϴ�.</h2>
<table>
<tr><td>�̸�</td><td><%=name %></td></tr>
<tr><td>����</td><td><%=gender %></td></tr>
<tr><td>����</td><td><%=major %></td></tr>
<tr><td>���</td><td><%for(int i=0; i<hobby.length; i++){ %>  <%--�迭 ���̸�ŭ �޾ƿ� ���� ���, üũ�ڽ� 2�� �̻� ������ ��� ������ ������ ��� ���� --%>
							<%=hobby[i]%>
<%						} %></td></tr>
</table>
</body>
</html>