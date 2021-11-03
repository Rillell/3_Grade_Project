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
	request.setCharacterEncoding("EUC-KR");

	String name = request.getParameter("name");
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String[] major = request.getParameterValues("major");
	
	if(gender.equals("man")){
		gender = "남자";
	}else{
		gender = "여자";
	}
%>
<h1>Request Example</h1>
성명: <%=name %><p>
학번: <%=studentNum %><p>
성별: <%=gender %><p>
학과: 
<%
	for(String m : major)
		out.println(m + " ");
%><p>
</body>
</html>