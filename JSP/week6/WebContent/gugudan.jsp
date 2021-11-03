<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>단을 입력하시오</h1>
<form method="post" action="gugudanProc.jsp"> <%--post방식으로 gugudanProc.jsp로 데이터 전송 --%>
<input type="number" name="num" min="1" max="9"> <%--number타입으로 정해진 범위의 숫자 조절 가능 --%>
<input type="submit" value="보내기"> <%--폼 핸들러로 폼 데이터 전송 --%>
</form>
</body>
</html>