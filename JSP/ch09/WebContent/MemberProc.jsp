<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="regBean" class="ch09.MemberBean" />
<jsp:setProperty name="regBean" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<br/><br/>
<form name="regForm" method="post" action="memberInsert.jsp">
<table>
	<tr>
		<td colspan="2" class="title" >
			<jsp:getProperty name="regBean" property="name" />
			ȸ������ �ۼ��Ͻ� �����Դϴ�. Ȯ���� �ּ���.
		</td>
	</tr>
	<tr>
		<td width="175px">���̵�</td>
		<td><jsp:getProperty name="regBean" property="id" /></td>
	</tr>
	<tr>
		<td>�н�����</td>
		<td><jsp:getProperty name="regBean" property="pwd"/></td>	
	</tr>
	<tr>
		<td>�̸�</td>
		<td><jsp:getProperty name="regBean" property="name" /></td>
	</tr>
	<tr>
		<td>�������</td>
		<td><jsp:getProperty name="regBean" property="birthday" /></td>
	</tr>
	<tr>
		<td>�̸���</td>
		<td><jsp:getProperty name="regBean" property="email" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="Ȯ�οϷ�"> &nbsp;
			<input type="button" value="�ٽþ���" onClick="history.back()">
		</td>
	</tr>
</table>

</form>
</body>
</html>