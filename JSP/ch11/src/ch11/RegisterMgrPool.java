package ch11;

import java.sql.*;
import java.util.Vector;

public class RegisterMgrPool {
	
	private DBConnectionMgr pool = null;
	
	public RegisterMgrPool() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Vector<RegisterBean> getRegisterList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Vector<RegisterBean> vlist = new Vector<RegisterBean>();
		
		try {
			conn = pool.getConnection();
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
			pool.freeConnection(conn, stmt, rs);
		}
		
		return vlist;
	}
}
