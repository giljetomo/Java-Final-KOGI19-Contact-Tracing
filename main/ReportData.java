package kogi19.main;

import java.sql.Date;

public class ReportData {
	private String sourceId;
	private String sourceName;
	private String exposedId;
	private String exposedName;
	private String age;
	private String phone;
	private Date exposureDate;
	private String location;
	
	public ReportData(String sourceId, String sourceName, String exposedId, String exposedName, String age,
			String phone, Date exposureDate, String location) {
		super();
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.exposedId = exposedId;
		this.exposedName = exposedName;
		this.age = age;
		this.phone = phone;
		this.exposureDate = exposureDate;
		this.location = location;
	}
	
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getExposedId() {
		return exposedId;
	}
	public void setExposedId(String exposedId) {
		this.exposedId = exposedId;
	}
	public String getExposedName() {
		return exposedName;
	}
	public void setExposedName(String exposedName) {
		this.exposedName = exposedName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getExposureDate() {
		return exposureDate;
	}
	public void setExposureDate(Date exposureDate) {
		this.exposureDate = exposureDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
