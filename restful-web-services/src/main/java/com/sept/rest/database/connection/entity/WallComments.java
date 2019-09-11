package com.sept.rest.database.connection.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
	@Id
	private Integer StudentID;
	private String Given_Name;
	private String Family_Name;
	private String Display_Name;
	
	public int getID() {
		return StudentID;
	}
	
	public String getDisplayName() {
		return Display_Name;
	}
	
	public void setID(Integer id) {
		StudentID = id;
	}
	
	public void setGiven_Name(String name) {
		Given_Name = name;
	}
	
	public void setFamily_Name(String name) {
		Family_Name = name;
	}
	
	public void setDisplay_Name(String name) {
		Display_Name = name;
	}
}
	