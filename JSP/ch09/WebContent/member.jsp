<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<title>ȸ������</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body>
<br/><br/>
<form name="regForm" method="post" action="MemberProc.jsp">
<table>
    <tr> 
      <td colspan="3" class="title">ȸ�� ����</td>
    </tr>
    <tr> 
      <td width="100">���̵�</td>
      <td width="200"><input type="text" name="id" size="15" ></td>
      <td width="200">���̵� ���� �ּ���.</td>
    </tr>
    <tr> 
      <td>�н�����</td> 
      <td><input type="password" name="pwd" size="15" ></td>
      <td>�н����带 �����ּ���.</td>
    </tr>
    <tr> 
      <td>�н����� Ȯ��</td>
      <td><input type="password" name="repwd" size="15" ></td>
      <td>�н����带 Ȯ���մϴ�.</td>
    </tr>
    <tr>  
      <td>�̸�</td>
      <td><input name="name" size="15" ></td>
      <td>���Ǹ��� �����ּ���.</td>
    </tr>
    <tr> 
      <td>�������</td>
      <td><input name="birthday" size="27" ></td>
      <td>��������� �����ּ���.</td>
    </tr>
    <tr>  
      <td>�̸���</td>
      <td><input name="email" size="20"></td>
      <td>�̸����� �����ּ���.</td>
    </tr>
    <tr> 
      <td colspan="3" align="center"> 
       <input type="button" value="ȸ������" onclick="inputCheck()"> &nbsp; 
       <input type="reset" value="�ٽþ���"> 
      </td>
    </tr>
</table>
</form>  
</body>
</html>