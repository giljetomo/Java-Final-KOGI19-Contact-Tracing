package kogi19.main;

import java.sql.Date;

public class Clinic {
	
	private String name;
	private String personId;
	private Date testdate;
	private String result;
	
	
	public Clinic(String name, String personId, Date testDate, String result) {
		setName(name);
		setPersonId(personId);
		setTestdate(testDate);
		setResult(result);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPersonId() {
		return personId;
	}
	
	public void setPersonId(String personId) {
		this.personId = personId;
	}



	public Date getTestdate() {
		return testdate;
	}


	public void setTestdate(Date testdate) {
		this.testdate = testdate;
	}
	
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		if (result.equalsIgnoreCase("Positive")) {
			this.result = "P";
		} else if(result.equalsIgnoreCase("Negative")) {
			this.result = "N";
		}
		
	}
	

}
