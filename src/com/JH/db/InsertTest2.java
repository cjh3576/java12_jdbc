package com.JH.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {
		//부서번호, 부서명, 지역명 입력받아서 dept 테이블에 입력
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
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			System.out.println("deptno 입력");
			int deptno = sc.nextInt();
			System.out.println("dname 입력");
			String dname = sc.next();
			System.out.println("loc 입력");
			String loc = sc.next();
			
			String sql = "insert into dept values(" +deptno+",'"+ dname+"'" +",'"+loc +"'"+")";
			System.out.println(sql);
			st = con.createStatement();
			result = st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
				sc.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		if(result >0 ) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		
		
	}

}
