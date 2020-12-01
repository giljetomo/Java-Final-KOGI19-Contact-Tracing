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

import javax.swing.table.DefaultTableModel;

import kogi19.databaseConstants.DBConstants;
import kogi19.main.Clinic;
import kogi19.main.Individual;
import kogi19.main.LineChartData;
import kogi19.main.Location;
import kogi19.main.ReportData;


public class DatabaseHandler {
	
	//instance variables
	private static DatabaseHandler handler = null;
	Connection conn = null;	
	//constructor
	public DatabaseHandler() {
		createConnection();
	}
	
	//methods
	
//	ei_person_id varchar (7) primary key,
//	si_person_id varchar (7),
//	location_id int,
//	exposure_date date,
	
	public boolean addExposedIndividual(String eiPersonId, String siPersonId, int locationId, Date dateExposed) {
		boolean successful = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO exposed_individual VALUES (?, ?, ?, ?)");
			pstmt.setString(1, eiPersonId);
			pstmt.setString(2, siPersonId);
			pstmt.setInt(3, locationId);
			pstmt.setDate(4, dateExposed);
			
			int record = pstmt.executeUpdate();
			
			if(record == 1) {
				successful = true;
			}
			
		} catch (Exception e) {
//			// e.printStackTrace();
		}
		return successful;
	}
	
	public String getSelectedExposedIndividual(int selectedIndex) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT person_id, pname FROM individual WHERE person_id not in (SELECT person_id FROM results) and person_id not in (SELECT ei_person_id FROM exposed_individual)",  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.absolute(selectedIndex + 1)) {
				return rs.getString(1);
				
			}
			
		} catch (SQLException e) {
//			// e.printStackTrace();
		}
		
		return null;
	}
	
	public int getSourceIndividualLocationId(int selectedIndex, String personId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT location_id FROM location WHERE si_person_id = ?",  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1, personId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.absolute(selectedIndex + 1)) {
				return rs.getInt(1);
				
			}
						
		} catch (SQLException e) {
//			// e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
	public ArrayList<String> getPossibleExposedIndividuals() {
		ArrayList<String> individuals = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT person_id, pname FROM individual WHERE person_id not in (SELECT person_id FROM results) and person_id not in (SELECT ei_person_id FROM exposed_individual)");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				individuals.add(rs.getString(1) + " - " + rs.getString(2));
			}
			
			return individuals;
			
		} catch (SQLException e) {
//			// e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> getSourceIndividualLocations(String personId) {
		ArrayList<String> locations = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT location_id,  location_name FROM location WHERE si_person_id = ?");
			pstmt.setString(1, personId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				locations.add(rs.getInt(1) + " - " + rs.getString(2));
			}
			
			return locations;
			
		} catch (SQLException e) {
//			// e.printStackTrace();
		}
		
		return null;
	}
	
	
	public boolean addNewLocation(Location location) {
		boolean successful = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO location(location_name, location_address, si_person_id) VALUES (?, ?, ?)");
			pstmt.setString(1, location.getLocationName());
			pstmt.setString(2, location.getLocationAddress());
			pstmt.setString(3, location.getPersonId());
			
			
			int record = pstmt.executeUpdate();
			
			if(record == 1)
				successful = true;			
			
		} catch (Exception e) {
//			// e.printStackTrace();
		}
		return successful;
	}
	
	public String getSourcePersonId(int selectedIndex) {
		String personId = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT a.person_id, b.pname FROM results a, individual b WHERE a.result = 'P' and a.person_id = b.person_id",  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.absolute(selectedIndex + 1)) {
				return rs.getString(1);
				
			}
			
			return personId;
			
		} catch (SQLException e) {
//			// e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> getSourceIndividuals() {
		ArrayList<String> individuals = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT a.person_id, b.pname FROM results a, individual b WHERE a.result = 'P' and a.person_id = b.person_id");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				individuals.add(rs.getString(1) + " - " + rs.getString(2));
			}
			
			return individuals;
			
		} catch (SQLException e) {
//			// e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<LineChartData> getListOfPositiveCases() {
		
		ArrayList<LineChartData> data = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("select testing_date, count(*) from results where result = 'P' group by testing_date order by testing_date");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				data.add(new LineChartData(rs.getString(1), rs.getString(2)));
			}
			
			return data;
		} catch (Exception e) {
//			// e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<LineChartData> getListOfTotalCases() {
		
		ArrayList<LineChartData> data = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("select testing_date, count(*) from results group by testing_date order by testing_date");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				data.add(new LineChartData(rs.getString(1), rs.getString(2)));
			}
			
			return data;
		} catch (Exception e) {
//			// e.printStackTrace();
		}
		
		return null;
	}
	
	
	private void addSourceIndividual(String personId, String condition, int clinicId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO source_individual VALUES (?, ?, ?)");
			pstmt.setString(1, personId);
			pstmt.setString(2, condition);
			pstmt.setInt(3, clinicId);
			
			int record = pstmt.executeUpdate();
			
		} catch (Exception e) {
//			// e.printStackTrace();
		}
	}
	
	public ArrayList<ReportData> getArrayListOfDataForReport() {
		
		ArrayList<ReportData> rd = new ArrayList<>();
		
//		source_id, source name, exposed_id, exposed_name, age, phone, exposure_date, location
		try {
			PreparedStatement pstmt = conn.prepareStatement("select a.si_person_id as 'SOURCE_ID', b.pname as 'SOURCE_NAME', a.ei_person_id as 'EI_ID', c.pname as 'EXPOSED_INDIVIDUAL', YEAR(CURDATE()) - YEAR(b.birthdate) AS 'AGE', c.contact as 'PHONE', a.exposure_date as 'EXPOSURE DATE', d.location_name as 'LOCATION', f.name as 'CLINIC NAME', e.result as 'RESULT' from exposed_individual a left join individual b on a.si_person_id = b.person_id left join individual c on a.ei_person_id = c.person_id inner join location d on a.location_id = d.location_id left join results e on a.ei_person_id = e.person_id left join clinic f on e.clinic_id = f.clinic_id order by a.si_person_id");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
	
			rd.add(new ReportData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			
			}
			
			return rd;
			
		} catch (SQLException e) {
			
//			// e.printStackTrace();
		}
				
		return null;				
				
	}
	
	public DefaultTableModel getDataForReport() {
		ArrayList<ReportData> rd = new ArrayList<>();
		
//		source_id, source name, exposed_id, exposed_name, age, phone, exposure_date, location
		try {
//			PreparedStatement pstmt = conn.prepareStatement("select a.si_person_id as source, c.pname, a.ei_person_id as exposed, b.pname, YEAR(CURDATE()) - YEAR(b.birthdate) AS age, b.contact as phone, a.exposure_date, d.location_name as location from exposed_individual a, individual b, individual c, location d where b.person_id = a.ei_person_id and a.si_person_id = c.person_id and a.location_id = d.location_id");
			PreparedStatement pstmt = conn.prepareStatement("select a.si_person_id as 'SOURCE_ID', b.pname as 'SOURCE_NAME', a.ei_person_id as 'EI_ID', c.pname as 'EXPOSED_INDIVIDUAL', YEAR(CURDATE()) - YEAR(b.birthdate) AS 'AGE', c.contact as 'PHONE', a.exposure_date as 'EXPOSURE DATE', d.location_name as 'LOCATION', f.name as 'CLINIC NAME', e.result as 'RESULT' from exposed_individual a left join individual b on a.si_person_id = b.person_id left join individual c on a.ei_person_id = c.person_id inner join location d on a.location_id = d.location_id left join results e on a.ei_person_id = e.person_id left join clinic f on e.clinic_id = f.clinic_id order by a.si_person_id");
			ResultSet rs = pstmt.executeQuery();
			
			DefaultTableModel model = new DefaultTableModel();

			model.addColumn("SOURCE_ID");
			model.addColumn("SOURCE NAME");
			model.addColumn("EXPOSED_ID");
			model.addColumn("EXPOSED NAME");
			model.addColumn("AGE");
			model.addColumn("PHONE");
			model.addColumn("EXPOSURE DATE");
			model.addColumn("LOCATION");
			model.addColumn("CLINIC NAME");
			model.addColumn("RESULT");
			

			while(rs.next()) {
				
				model.addRow(new Object[] {
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getDate(7).toString(),
					rs.getString(8),
					rs.getString(9),
					rs.getString(10)
					
				});
				
			rd.add(new ReportData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			
			}
			
//			for(ReportData data : rd) {
//				System.out.printf("%s %s %s %s %s %s %s %s", data.getSourceId(), data.getSourceName(), data.getExposedId(), data.getExposedName(), data.getAge(), data.getPhone(), data.getExposureDate(), data.getLocation());
//				System.out.println();
//			}
			
		return model;
			
		} catch (SQLException e) {
			
//			// e.printStackTrace();
		}
		
				
		return null;				
				
	}
	
	public boolean addResult(String personId, int clinicId, String result, Date dateTested, String condition) {
		boolean successful = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO results VALUES (?, ?, ?, ?)");
			pstmt.setString(1, personId);
			pstmt.setInt(2, clinicId);
			pstmt.setString(3, result);
			pstmt.setDate(4, dateTested);
			
			int record = pstmt.executeUpdate();
			
			if(record == 1) {
				successful = true;
				if (result.equalsIgnoreCase("P")) {
					String formattedCondition = "";
					if (condition.equalsIgnoreCase("Symptomatic")) {
						formattedCondition = "S";
					} else if (condition.equalsIgnoreCase("Asymptomatic")){
						formattedCondition = "A";
					}
					addSourceIndividual(personId, formattedCondition, clinicId);						
				}
			}
			
		} catch (Exception e) {
//			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
//			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
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
			// e.printStackTrace();
		}
		
		return noData;
	}
	
	private void createConnection() {
		
		try {
			conn = DriverManager.getConnection(DBConstants.CONN_STRING, DBConstants.USER, DBConstants.PASSWORD);
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}
}

