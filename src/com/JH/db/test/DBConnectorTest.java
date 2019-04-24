package com.JH.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.JH.db.util.DBConnector;

public class DBConnectorTest {

	@Test
	public void test() throws Exception {
		Connection con = 	DBConnector.getConnect();
		assertNotNull(con);

	}

}
