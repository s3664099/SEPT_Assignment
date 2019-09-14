package com.sept.rest.webservices.user;

import javax.persistence.Entity;
import javax.persistence.Id;

//Stub for the user to allow testing of wall & post
@Entity
public class Students {
	
	//basic student variables
	@Id
	private int StudentID;
	private String Display_Name;
	private String Given_Name;
	private String Family_Name;
	
	public Students(String displayName, int studentId, String giveName, String famName) {
		
		this.Display_Name = displayName;
		this.StudentID = studentId;
		this.Given_Name = giveName;
		this.Family_Name = famName;
	
	}

	public String getDisplay_Name() {
		return Display_Name;
	}

	public void setDisplay_Name(String display_Name) {
		Display_Name = display_Name;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getGiven_Name() {
		return Given_Name;
	}

	public void setGiven_Name(String given_Name) {
		Given_Name = given_Name;
	}

	public String getFamily_Name() {
		return Family_Name;
	}

	public void setFamily_Name(String family_Name) {
		Family_Name = family_Name;
	}
	
}
