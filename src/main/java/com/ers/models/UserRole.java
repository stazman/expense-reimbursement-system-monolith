package com.ers.models;

public class UserRole {

	private int userRoleId; // primary key
	private String userRole; // not null, unique

	public UserRole(int userRoleId, String userRole) {
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}

    public UserRole() {

    }

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
	}
	
	
	
}
