package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "book_ex";
		String password = "book_ex";
		
		try(Connection con = DriverManager.getConnection(url, user, password)) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
