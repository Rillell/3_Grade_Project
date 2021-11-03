<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id = "";
	String pwd = "";
	String name = "";
	String num1 = "";
	String num2 = "";
	String email = "";
	String phone = "";
	String zipcode = "";
	String address = "";
	String job = "";
	
	int counter = 0;
	
	try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "root", "1234");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from tblregister");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href = "style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align = "center">
<h2>JSP 스크립트릿에서 데이터베이스 연동 예제</h2>
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
	if(rs!=null){
		while(rs.next()){
			id = rs.getString("id");
			pwd = rs.getString("pwd");
			name = rs.getString("name");
			num1 = rs.getString("num1");
			num2 = rs.getString("num2");
			email = rs.getString("email");
			phone = rs.getString("phone");
			zipcode = rs.getString("zipcode");
			address = rs.getString("address");
			job = rs.getString("job");
%>
			<tr>
				<td><%=id %></td>
				<td><%=pwd %></td>
				<td><%=name %></td>
				<td><%=num1 %></td>
				<td><%=num2 %></td>
				<td><%=email %></td>
				<td><%=phone %></td>
				<td><%=zipcode %> / <%=address %></td>
				<td><%=job %></td>
			</tr>
<%
			counter++;
		} //end while
	} //end if
%>
</table>
total records : <%=counter %>
</div>

<% 
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){}
		}
		
		if(stmt != null){
			try{
				stmt.close();
			}catch(Exception e){}
		}
		
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
%>

</body>
</html>