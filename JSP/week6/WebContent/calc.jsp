<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>�ǿ����ڿ� �����ڸ� �Է��Ͻÿ�.</h1>
<form method="post" action="calcProc.jsp"> <%--post������� calcProc.jsp�� ������ ����--%>
����1: <input name="num1"><p>  <%-- num1�� �Է� --%>
����2: <input name="num2"><p>  <%-- num2�� �Է� --%>
������: <select name="op">  <%--��Ӵٿ� ����Ʈ �ۼ� --%>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="X">X</option>
		<option value="/">/</option>
</select><p>

<input type="submit" value="������">  <%--calcProc.jsp�� ������ ������--%>

</form>
</body>
</html>