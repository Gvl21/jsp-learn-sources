package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	public static void close(AutoCloseable... closer) {
		for(AutoCloseable close : closer) {
		try {
			if(close!=null) {
				close.close();
			}
		
		} catch (Exception e) {}
	}
	}
	/*
	public static void close(Connection conn) {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null) stmt.close();
		} catch (SQLException e) {}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {}
		
	}
*/
}
