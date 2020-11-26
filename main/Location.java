package kogi19.main;

public class Location {
	
//	location_name location_address si_person_id 
	private String locationName;
	private String locationAddress;
	private String personId;
	
	
	
	public Location(String locationName, String locationAddress, String personId) {
		setLocationName(locationName);
		setLocationAddress(locationAddress);
		setPersonId(personId);
	}
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationAddress() {
		return locationAddress;
	}
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	
	
	
	
	

}
