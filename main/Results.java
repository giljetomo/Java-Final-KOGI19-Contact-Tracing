package kogi19.main;

import java.sql.Date;

public class Results {
	
	private String personId;
	private Date testdate;
	private String result;
	
	
	public Results(String personId, Date testDate, String result) {
		setPersonId(personId);
		setTestdate(testDate);
		setResult(result);
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
