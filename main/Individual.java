package kogi19.main;

import java.sql.Date;

public class Individual {
	
	private String name;
	private String gender;
	private Date birthdate;
	private String contact;
	private String address;
	
	
	public Individual(String name, String gender, Date birthdate, String contact, String address) {
		setName(name);
		setGender(gender);
		setBirthdate(birthdate);
		setContact(contact);
		setAddress(address);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("M")) {
			this.gender = "M";
		} else if(gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("F")) {
			this.gender = "F";
		}
		
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
