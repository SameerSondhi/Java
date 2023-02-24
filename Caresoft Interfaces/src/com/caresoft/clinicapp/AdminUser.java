package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

//Inside class:
private Integer employeeID;
private String role;
private ArrayList<String> securityIncidents = new ArrayList<String>();

// TO DO: Implement a constructor that takes an ID and a role
public AdminUser(Integer employeeID, String role) {
	super(employeeID);
	this.employeeID=employeeID;
	this.role = role;
}

// TO DO: Implement HIPAACompliantUser!
@Override
public boolean assignPin(int pin) {
	// TODO Auto-generated method stub
	int length = String.valueOf(pin).length();
	if(length==6) {
	return true;
}
	return false;
}

@Override
public boolean accessAuthorized(Integer confirmedAuthID) {
	// TODO Auto-generated method stub
	if(this.id==confirmedAuthID) {
		newIncident("Passed");
		return true;
	}
	else {
		authIncident();
		return false;
		}
		
	}
	

// TO DO: Implement HIPAACompliantAdmin!
@Override
public ArrayList<String> reportSecurityIncidents() {
	// TODO Auto-generated method stub
	return securityIncidents;
}


public void newIncident(String notes) {
    String report = String.format(
        "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
        new Date(), this.id, notes
    );
    securityIncidents.add(report);
}
public void authIncident() {
    String report = String.format(
        "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
        new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
    );
    securityIncidents.add(report);
}


// TO DO: Setters & Getters
//GET EMPLOYEE ID
public Integer getEmployeeID() {
	return employeeID;
}

//SET EMPLOYEE ID
public void setEmployeeID(Integer employeeID) {
	this.employeeID = employeeID;
}

//GET ROLE
public String getRole() {
	return role;
};

//SET ROLE
public void setRole(String role) {
	this.role = role;
}
//GET SECURITY INCIDENTS
public ArrayList<String> getSecurityIncidents(){
	return securityIncidents;
}

//SET SECURITY INCIDENTS
public void setSecurityIncidents(ArrayList<String> securityIncidents) {
	this.securityIncidents = securityIncidents;
}
}