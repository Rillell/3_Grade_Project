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
		border-collapse :collapse;   <%--테두리가 중첩될 경우 겹침--%>
		width:300px;
	}	
	td{
		border : 1px solid black;
	}	
</style>
</head>
<body>
<% 
	request.setCharacterEncoding("EUC-KR"); //한글처리
	String name = request.getParameter("name"); //이름
	String gender = request.getParameter("gender"); //성별
	String major = request.getParameter("major"); //학과
	String[] hobby = request.getParameterValues("hobby"); //배열로 하여 체크박스 데이터 여러개 받아올수 있도록
%>

<h2><%=name %>님이 입력한 정보입니다.</h2>
<table>
<tr><td>이름</td><td><%=name %></td></tr>
<tr><td>성별</td><td><%=gender %></td></tr>
<tr><td>전공</td><td><%=major %></td></tr>
<tr><td>취미</td><td><%for(int i=0; i<hobby.length; i++){ %>  <%--배열 길이만큼 받아온 정보 출력, 체크박스 2개 이상 선택한 경우 데이터 여러개 출력 가능 --%>
							<%=hobby[i]%>
<%						} %></td></tr>
</table>
</body>
</html>