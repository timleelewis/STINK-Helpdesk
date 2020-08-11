package com.stinkelectronics.helpdesk.model;

import java.util.ArrayList;
import java.util.List;

public class Profile{

	private String UserID;
	private String FirstName;
	private String LastName;
	
	private String Email;
	private String Password;

	private int RoleID;
	private int RepairID;
	
	public Profile() {
		this.UserID = "defaultuserid";
		
		this.FirstName = "defaultfirstname";
		this.LastName = "defaultlastname";
		
		this.Email = "mail@mail.com";
		this.Password = "defaultpassword";
		
		this.RoleID = 1;
		this.RepairID = 0;
	}

	public Profile(String UserID, String FirstName, String LastName, String Email, String Password, int RoleID, int RepairID) {
		this.UserID = UserID;

		this.FirstName = FirstName;
		this.LastName = LastName;
		
		this.Email = Email;
		this.Password = Password;

		this.RoleID = RoleID;
		this.RepairID = RepairID;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		this.Password = password;
	}

	public int getRoleID() {
		return RoleID;
	}

	public void setRoleID(int roleID) {
		RoleID = roleID;
	}

	public int getRepairID() {
		return RepairID;
	}

	public void setRepairID(int repairID) {
		RepairID = repairID;
	}
}
