package com.JH.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest1 {

	public static void main(String[] args) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.24:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from dept order by deptno desc";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			while(rs.next()) {
				System.out.print("부서번호 : " + rs.getInt("deptno"));
				System.out.print("\t부서명 : " + rs.getString("dname"));
				System.out.println("\t지역명 : " + rs.getString("loc"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
