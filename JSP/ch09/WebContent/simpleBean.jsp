<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "ch09.SimpleBean" %>
<jsp:useBean id="test" class="ch09.SimpleBean" />
<jsp:setProperty name="test" property="message" value="���� ��������!" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>������ �� ���α׷���</h1>
<br/>
Message: <jsp:getProperty name="test" property="message" />
<br/>

</body>
</html>