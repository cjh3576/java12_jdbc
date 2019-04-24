package com.JH.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest3 {

	public static void main(String[] args) {
		//부서 갯수, 부서번호 제일큰거작은거
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

			String sql = "select count(deptno), max(deptno), min(deptno) from dept";

			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			
			System.out.println("부서갯수 : " + rs.getInt("count(deptno)"));
			System.out.println("제일큰거 : " + rs.getInt("max(deptno)"));
			System.out.println("제일작은거 : " + rs.getInt("min(deptno)"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}

}
