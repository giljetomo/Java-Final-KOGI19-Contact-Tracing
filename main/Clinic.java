package kogi19.main;

public class Clinic {

	private String name;
	private String address;
	
	
	public Clinic(String name, String address) {
		setName(name);
		setAddress(address);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
