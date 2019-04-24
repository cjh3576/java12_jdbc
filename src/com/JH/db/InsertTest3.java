package com.JH.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest3 {

	public static void main(String[] args) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.24:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		Statement st = null;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("연결성공");
			System.out.println("empno : ");
			
			String sql = "insert into emp values(" + sc.nextInt()+",'" + sc.next() + "','" + sc.next() + "',"+sc.nextInt()+"," +"sysdate, 1000,0,30)";
			System.out.println(sql);
			st = con.createStatement();
			result = st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
