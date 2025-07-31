package com.bornfire.xbrl.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Date;

public class CallStoredProcedure {
	public void callBreconMappingProcedure(Date reportDate) {
		String jdbcUrl = "jdbc:oracle:thin:@103.11.152.132:1521/XBRLDB";
		String username = "CXBRL";
		String password = "CXBRL";

		Connection conn = null;
		CallableStatement stmt = null;
		System.out.println("the getting procedure date is " + reportDate);
		try {
			// Load the JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Establish the connection
			conn = DriverManager.getConnection(jdbcUrl, username, password);

			// Prepare the callable statement for your stored procedure
			String sql = "{call BRECON_MAPPING_PROCEDURE(?)}"; // Adjust based on your procedure
			stmt = conn.prepareCall(sql);

			// Set the input parameter (ensure reportDate is in java.sql.Date format)
			stmt.setDate(1, reportDate);

			// Execute the stored procedure
			stmt.execute();

			System.out.println("Stored procedure executed successfully with date: " + reportDate);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
