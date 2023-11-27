package com.organization.employee.model;

import lombok.ToString;

@ToString
public class Employee  {

	
	private String empId;
	private String empFirstName;
	private String empLastName;
	private String clientId;

	private String oranizationID;	
	private String location;

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public String getOranizationID() {
		return oranizationID;
	}
	public void setOranizationID(String oranizationID) {
		this.oranizationID = oranizationID;
	}
	

	

}