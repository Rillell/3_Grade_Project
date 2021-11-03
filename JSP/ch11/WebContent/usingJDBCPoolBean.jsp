<%@ page contentType="text/html;charset=EUC-KR"%>
<%@ page import="java.util.Vector,ch11.*" %>
<jsp:useBean id="regMgr" class="ch11.RegisterMgrPool" />
<!DOCTYPE html>
<html>
<head>
<title>JSP에서 데이터베이스 연동</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
<div align="center">
	<h2>JSP 스크립틀릿에서 데이터베이스 연동 예제</h2><br/>
	<h3>회원정보</h3>
	<table>
		<tr>
		   <th>ID</th>
		   <th>PASSWD</th>
		   <th>NAME</th>
		   <th>NUM1</th>
		   <th>NUM2</th>
		   <th>EMAIL</th>
		   <th>PHONE</th>
		   <th>ZIPCODE/ADDRESS</th>
		   <th>JOB</th>
		</tr>
<%
	Vector<RegisterBean> vlist = regMgr.getRegisterList();
	int counter = vlist.size();
	for(int i = 0; i<vlist.size(); i++){
		RegisterBean regBean = vlist.get(i);
%>
		<tr>
			<td><%=regBean.getId()  %></td>
			<td><%=regBean.getPwd()  %></td>
			<td><%=regBean.getName()  %></td>
			<td><%=regBean.getNum1()  %></td>
			<td><%=regBean.getNum2()  %></td>
			<td><%=regBean.getEmail()  %></td>
			<td><%=regBean.getPhone()  %></td>
			<td><%=regBean.getZipcode()  %>  / <%=regBean.getAddress() %></td>
			<td><%=regBean.getJob()  %></td>
		</tr>
<%
	} //end for
%>

	</table>
	<br/>
	total records:<%=counter %>
</div>
</body>
</html>