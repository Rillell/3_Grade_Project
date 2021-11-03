<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>피연산자와 연산자를 입력하시오.</h1>
<form method="post" action="calcProc.jsp"> <%--post방식으로 calcProc.jsp로 데이터 전송--%>
숫자1: <input name="num1"><p>  <%-- num1값 입력 --%>
숫자2: <input name="num2"><p>  <%-- num2값 입력 --%>
연산자: <select name="op">  <%--드롭다운 리스트 작성 --%>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="X">X</option>
		<option value="/">/</option>
</select><p>

<input type="submit" value="보내기">  <%--calcProc.jsp로 데이터 보내기--%>

</form>
</body>
</html>