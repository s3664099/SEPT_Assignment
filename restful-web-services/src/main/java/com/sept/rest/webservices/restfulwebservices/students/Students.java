package com.sept.rest.webservices.restfulwebservices.students;

import javax.persistence.Entity;
import javax.persistence.Id;

//Stub for the user to allow testing of wall & post
@Entity
public class Students {
	
	public Students() {
		
	}
	
	//basic student variables
	@Id
	private int studentId;
	private String displayName;
	private String givenName;
	private String familyName;
	
	public Students(String displayName, int studentId, String giveName, String famName) {
		super();
		this.displayName = displayName;
		this.studentId = studentId;
		this.givenName = giveName;
		this.familyName = famName;
	
	}

	public String getDisplay_Name() {
		return displayName;
	}

	public void setDisplay_Name(String display_Name) {
		displayName = display_Name;
	}

	public int getStudentID() {
		return studentId;
	}

	public void setStudentID(int studentID) {
		studentId = studentID;
	}

	public String getGiven_Name() {
		return givenName;
	}

	public void setGiven_Name(String given_Name) {
		givenName = given_Name;
	}

	public String getFamily_Name() {
		return familyName;
	}

	public void setFamily_Name(String family_Name) {
		familyName = family_Name;
	}
	
}
