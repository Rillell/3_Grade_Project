<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body>
<br/><br/>
<form name="regForm" method="post" action="MemberProc.jsp">
<table>
    <tr> 
      <td colspan="3" class="title">회원 가입</td>
    </tr>
    <tr> 
      <td width="100">아이디</td>
      <td width="200"><input type="text" name="id" size="15" ></td>
      <td width="200">아이디를 적어 주세요.</td>
    </tr>
    <tr> 
      <td>패스워드</td> 
      <td><input type="password" name="pwd" size="15" ></td>
      <td>패스워드를 적어주세요.</td>
    </tr>
    <tr> 
      <td>패스워드 확인</td>
      <td><input type="password" name="repwd" size="15" ></td>
      <td>패스워드를 확인합니다.</td>
    </tr>
    <tr>  
      <td>이름</td>
      <td><input name="name" size="15" ></td>
      <td>고객실명을 적어주세요.</td>
    </tr>
    <tr> 
      <td>생년월일</td>
      <td><input name="birthday" size="27" ></td>
      <td>생년월일을 적어주세요.</td>
    </tr>
    <tr>  
      <td>이메일</td>
      <td><input name="email" size="20"></td>
      <td>이메일을 적어주세요.</td>
    </tr>
    <tr> 
      <td colspan="3" align="center"> 
       <input type="button" value="회원가입" onclick="inputCheck()"> &nbsp; 
       <input type="reset" value="다시쓰기"> 
      </td>
    </tr>
</table>
</form>  
</body>
</html>