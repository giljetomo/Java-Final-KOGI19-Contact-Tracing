package kogi19.DatabaseHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import kogi19.databaseConstants.DBConstants;
import kogi19.main.Clinic;
import kogi19.main.Individual;


public class DatabaseHandler {
	
	//instance variables
	private static DatabaseHandler handler = null;
	Connection conn = null;	
	//constructor
	public DatabaseHandler() {
		createConnection();
	}
	
	//methods
	
	
	
	public boolean addResult(int clinicId, String result, Date dateTested, String personId) {
		boolean successful = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO results VALUES (?, ?, ?, ?)");
			pstmt.setInt(1, clinicId);
			pstmt.setString(2, result);
			pstmt.setDate(3, dateTested);
			pstmt.setString(4, personId);
			
			int record = pstmt.executeUpdate();
			
			if(record == 1)
				successful = true;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successful;
	}
	
	public String getPersonId(int selectedIndex) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM individual WHERE person_id not in (SELECT person_id FROM results)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = pstmt.executeQuery();
			if(rs.absolute(selectedIndex + 1)) {
				return rs.getString(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public int getClinicId(int selectedIndex) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clinic", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = pstmt.executeQuery();
			if(rs.absolute(selectedIndex + 1)) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public ArrayList<String> getClinics() {
		ArrayList<String> clinics = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clinic");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				clinics.add(rs.getString(1) + " - " + rs.getString(2));
			}
			
			return clinics;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static DatabaseHandler getInstance() {
		if(Objects.isNull(handler)) {
			handler = new DatabaseHandler();
		}
		
		return handler;
	}
	
	
	public boolean addNewClinic(Clinic clinic) {
		boolean successful = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO clinic(name, address) VALUES (?, ?)");
			pstmt.setString(1, clinic.getName());
			pstmt.setString(2, clinic.getAddress());
			
			int record = pstmt.executeUpdate();
			
			if(record == 1)
				successful = true;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successful;
	}
	
	
	public boolean checkClinic(String clinicName) {
		
		//check for existing user
		//if it exists change, if not prompt the user
		boolean isFound = false;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clinic WHERE name = ?");
			pstmt.setString(1, clinicName);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.isBeforeFirst()) {
				isFound = true;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isFound;
	}
	
	
	
	public ArrayList<String> getIndividuals() {
		ArrayList<String> individuals = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM individual WHERE person_id not in (SELECT person_id FROM results)");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				individuals.add(rs.getString(1) + " - " + rs.getString(2));
			}
			
			return individuals;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getCurrentIndividualCount() {
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM individual");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int id = rs.getInt(1) + 1;
			
			return "KG00" + id; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean addNewIndividual(Individual individual) {
		boolean successful = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO individual VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, getCurrentIndividualCount());
			pstmt.setString(2, individual.getName());
			pstmt.setString(3, individual.getGender());
			pstmt.setDate(4, individual.getBirthdate());
			pstmt.setString(5, individual.getAddress());
			pstmt.setString(6, individual.getContact());
			
			int record = pstmt.executeUpdate();
			
			if(record == 1)
				successful = true;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successful;
		
	}
	
	
	public boolean addNewAdmin(String username, String password) {
		boolean successful = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO admin VALUES (?, md5(?), 'r')");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			int record = pstmt.executeUpdate();
			
			if(record == 1)
				successful = true;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return successful;
	}
	//Koji
	
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
	
//	public boolean checkContact(String contact) {
////		return 0;
//	}
	
	public boolean checkUser(String username) {
		
		//check for existing user
		//if it exists change, if not prompt the user
		boolean isFound = false;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ADMIN WHERE username = ?");
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.isBeforeFirst()) {
				isFound = true;
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

