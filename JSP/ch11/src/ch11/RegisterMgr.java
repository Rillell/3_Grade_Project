package ch11;

import java.sql.*;
import java.util.Vector;

public class RegisterMgr {
	
	private final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver"; //final:상수
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	private final String USER = "root";
	private final String PASS = "1234";
	
	public RegisterMgr() {
		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception ex) {
			System.out.println("JDBC 드라이버 로딩 실패");
			ex.printStackTrace();
		}
	}
	
	public Vector<RegisterBean> getRegisterList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Vector<RegisterBean> vlist = new Vector<RegisterBean>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			stmt = conn.createStatement();
			String strQuery = "select * from tblregister";
			rs = stmt.executeQuery(strQuery);
			
			while(rs.next()) {
				RegisterBean bean = new RegisterBean();
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setNum1(rs.getString("num1"));
				bean.setNum2(rs.getString("num2"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				bean.setJob(rs.getString("job"));
				vlist.addElement(bean);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(Exception e) {}
			}
			
			if(stmt!=null) {
				try {
					stmt.close();
				}catch(Exception e) {}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				}catch(Exception e) {}
			}
		}
		
		return vlist;
	}
}
