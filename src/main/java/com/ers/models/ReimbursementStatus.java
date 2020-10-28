package com.ers.models;

public class ReimbursementStatus {

	private int reimbStatusId; // primary key
	private String reimbStatus; // not null, unique

	public ReimbursementStatus(int reimbStatusId, String reimbStatus) {
		this.reimbStatusId = reimbStatusId;
		this.reimbStatus = reimbStatus;
	}

    public ReimbursementStatus() {

    }

    public ReimbursementStatus(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
    }

    public int getReimbStatusId() {
		return reimbStatusId;
	}


	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}


	public String getReimbStatus() {
		return reimbStatus;
	}


	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}


	@Override
	public String toString() {
		return "ReimbursementStatus [reimbStatusId=" + reimbStatusId + ", reimbStatus=" + reimbStatus + "]";
	}
	
}
