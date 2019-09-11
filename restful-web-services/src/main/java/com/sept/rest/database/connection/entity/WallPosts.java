package com.sept.rest.database.connection.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer PostID;
	private Integer OwnerID;
	private  Creation_Time;
	private  Modified_Time;
	private String Message;
	private Boolean Edited;
	private Boolean Deleted;
	
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
	