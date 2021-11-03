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
			회원님이 작성하신 내용입니다. 확인해 주세요.
		</td>
	</tr>
	<tr>
		<td width="175px">아이디</td>
		<td><jsp:getProperty name="regBean" property="id" /></td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td><jsp:getProperty name="regBean" property="pwd"/></td>	
	</tr>
	<tr>
		<td>이름</td>
		<td><jsp:getProperty name="regBean" property="name" /></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><jsp:getProperty name="regBean" property="birthday" /></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><jsp:getProperty name="regBean" property="email" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="확인완료"> &nbsp;
			<input type="button" value="다시쓰기" onClick="history.back()">
		</td>
	</tr>
</table>

</form>
</body>
</html>