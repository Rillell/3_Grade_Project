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
		border-collapse :collapse;  <%--�׵θ��� ��ø�� ��� ��ħ--%>
		width:500px;    <%-- ���̺� �ʺ�� 500px--%>
	}
	
	td{
		border : 1px solid black;
	}
</style>
</head>
<body>
<h3>�л� ����</h3>
<form method="post" action="studentProc.jsp"> <%--post��� --%>
<table>
	<tr>
		<td>�̸�</td><td><input name="name"></td> <%--�̸� �Է� --%>
	</tr>
	<tr>
		<td>����</td><td>����<input type="radio" name="gender" value="����">  <%--������ư --%>
						����<input type="radio" name="gender" value="����"></td>
	</tr>
	<tr>
		<td>����</td><td><select name="major">  <%--��Ӵٿ� ����Ʈ --%>
							<option value="�����а�" selected>�����а�</option> <%--�����а��� �⺻ ���õ� ���� --%>
							<option value="�����а�">�����а�</option>
							<option value="���а�">���а�</option>
							<option value="��ġ�а�">��ġ�а�</option>
							<option value="ü���а�">ü���а�</option>
	 					</select></td>
	 </tr>
	 <tr>
	 	<td>���</td>  <%--üũ�ڽ� ����Ʈ --%>
	 	<td><input type="checkbox" name="hobby" value="����">����
	 		<input type="checkbox" name="hobby" value="����">����
	 		<input type="checkbox" name="hobby" value="����">����
	 		<input type="checkbox" name="hobby" value="��ȭ����">��ȭ����</td>
	 </tr>
	 <tr>
	 	<td colspan="2" align="center"><input type="submit" value="ȸ������ ������"> <%--ȸ�� ���� ������ ��ư�� �ʱ�ȭ ��ư�� ����� ��ġ --%>
	 		<input type="reset" value="�ٽ� �Է�"></td> <%--reset : �ʱ�ȭ --%>
	</tr>
</table>
</form>
</body>
</html>