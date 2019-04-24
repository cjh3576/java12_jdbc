package com.JH.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest1 {

	public static void main(String[] args) {
		//부서번호를 입력받아 dept 테이블에서 삭제
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.24:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			String sql="Delete dept where deptno = ?";
			
			st = con.prepareStatement(sql);
			
			System.out.println("부서번호 입력");
			int deptno = sc.nextInt();
			st.setInt(1,deptno ); 
			
			result = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(result>0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

}
