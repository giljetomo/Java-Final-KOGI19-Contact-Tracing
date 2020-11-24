package kogi19.databaseScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import kogi19.databaseConstants.DBConstants;

public class DatabaseHandler {
	
	//instance variables
	private static DatabaseHandler handler = null;
	Connection conn = null;
	
	//constructor
	public DatabaseHandler() {
		createConnection();
	}
	
	//methods
	
	public static DatabaseHandler getInstance() {
		if(Objects.isNull(handler)) {
			handler = new DatabaseHandler();
		}
		
		return handler;
	}
	
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		boolean successful = false;

		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET pass = md5(?) WHERE username = ? and pass = md5(?)");
			pstmt.setString(1, newPassword);
			pstmt.setString(2, username);
			pstmt.setString(3, oldPassword);
			int record = pstmt.executeUpdate();
			
			if(record == 1)
				successful = true;			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return successful;
	}
	
	public boolean checkUser(String username) {
		
		//check for existing user
		//if it exists change, if not prompt the user
		boolean isFound = true;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM ADMIN WHERE username = ?");
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				isFound = false;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isFound;
	}

	public String validAdminUser(String username, String password) {
		
		String type = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT usertype FROM ADMIN WHERE username = ? and pass = md5(?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.isBeforeFirst()) {
				rs.next();
				return rs.getString("usertype");
			//	System.out.println(String.valueOf(rs.getString("usertype")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return type;
	}
	
	public boolean select() {
		
		boolean noData = true;

		try {
			PreparedStatement pstmt = conn.prepareStatement("select count(*) from admin");
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.isBeforeFirst()) {
				System.out.println("No data");
				
			} else {
				noData = true;
				rs.next();
				System.out.println(String.valueOf(rs.getInt(1)));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noData;
	}
	
	private void createConnection() {
		
		try {
			conn = DriverManager.getConnection(DBConstants.CONN_STRING, DBConstants.USER, DBConstants.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
