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
		border-collapse :collapse;  <%--테두리가 중첩될 경우 겹침--%>
		width:500px;    <%-- 테이블 너비는 500px--%>
	}
	
	td{
		border : 1px solid black;
	}
</style>
</head>
<body>
<h3>학생 정보</h3>
<form method="post" action="studentProc.jsp"> <%--post방식 --%>
<table>
	<tr>
		<td>이름</td><td><input name="name"></td> <%--이름 입력 --%>
	</tr>
	<tr>
		<td>성별</td><td>여자<input type="radio" name="gender" value="여자">  <%--라디오버튼 --%>
						남자<input type="radio" name="gender" value="남자"></td>
	</tr>
	<tr>
		<td>전공</td><td><select name="major">  <%--드롭다운 리스트 --%>
							<option value="국문학과" selected>국문학과</option> <%--국문학과가 기본 선택된 상태 --%>
							<option value="영문학과">영문학과</option>
							<option value="수학과">수학과</option>
							<option value="정치학과">정치학과</option>
							<option value="체육학과">체육학과</option>
	 					</select></td>
	 </tr>
	 <tr>
	 	<td>취미</td>  <%--체크박스 리스트 --%>
	 	<td><input type="checkbox" name="hobby" value="수영">수영
	 		<input type="checkbox" name="hobby" value="여행">여행
	 		<input type="checkbox" name="hobby" value="독서">독서
	 		<input type="checkbox" name="hobby" value="영화감상">영화감상</td>
	 </tr>
	 <tr>
	 	<td colspan="2" align="center"><input type="submit" value="회원정보 보내기"> <%--회원 정보 보내기 버튼과 초기화 버튼을 가운데에 위치 --%>
	 		<input type="reset" value="다시 입력"></td> <%--reset : 초기화 --%>
	</tr>
</table>
</form>
</body>
</html>