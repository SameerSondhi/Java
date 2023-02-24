package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
   
	// Implement a constructor that takes an ID
    public User(Integer id) {
    	this.id = id;
    }
    
    // TO DO: Getters and setters
    //GET ID
    	public Integer getId() {
    		return id;
    	}
    
    //SET ID
    	public void setId(Integer id) {
    		this.id = id;
    	}
}

