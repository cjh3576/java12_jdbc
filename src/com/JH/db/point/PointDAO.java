package com.JH.db.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.JH.db.util.DBConnector;

public class PointDAO {
	
	public  int insert (PointDTO pointDTO ) throws Exception{
		Scanner sc = new Scanner(System.in);
		Connection con = DBConnector.getConnect();
		String sql = "insert into point values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setInt(1, pointDTO.getNum());
		st.setString(2, pointDTO.getSid());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		st.setInt(8, pointDTO.getBnum());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		sc.close();
		return result;
	}
	
	public int delete() throws Exception {
		return 0;
		
	}
	
	
	
}
