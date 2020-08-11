package com.stinkelectronics.helpdesk.model;

public class Role {
	
	private int RoleID;
	private String Job;
	
	public Role() {
		this.RoleID = 0;
		this.Job = "N/A";
	}

	public Role(int RoleID, String Job) {
		this.RoleID = RoleID;
		this.Job = Job;
	}

	public int getRoleID() {
		return RoleID;
	}

	public void setRoleID(int roleID) {
		RoleID = roleID;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}
}
