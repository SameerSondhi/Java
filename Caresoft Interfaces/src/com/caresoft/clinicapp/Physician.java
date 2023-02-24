package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	
	//CONSTRUCTOR
	public Physician(Integer id){
		super(id);	
	}
	
	
	//IMPLEMENT HIPAA COMPLIANT USER
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int length = String.valueOf(pin).length();
		if(length==4) {
		return true;
	}
		return false;
	}


	@Override
	public boolean accessAuthorized(Integer id) {
		// TODO Auto-generated method stub
		if(id == this.id) {
			return true;
		}
		return false;
	}
	 
	
	 public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.id);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	    }


	
	 //GETTERS AND SETTERS
	 //GET ID
	 	public Integer getId() {
	 		return id;
	 	}
	 	
	 //SET ID
	 	public void setId(Integer id) {
	 		this.id= id;
	 	}

}
