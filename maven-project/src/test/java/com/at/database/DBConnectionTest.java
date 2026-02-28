package com.at.database;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DBConnectionTest {

	@Test
	void testGetConnection() {
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
			
			System.out.println(connection);
			assertNotNull(connection);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
