package com.human.jeungsangdiary;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class OracleDBConnTest {

	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "human";
	private static final String PASSWORD = "123456";

	@Test
	public void testOracleConnect() throws Exception {
		Class.forName(DRIVER);
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("접속 객체는 : " + conn);
		} catch(Exception e) {
			
		}
	}
}
