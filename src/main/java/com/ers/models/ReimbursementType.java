package com.ers.models;

public class ReimbursementType {

	private int reimbTypeId; // primary key
	private String reimbType; // not null, unique


	public ReimbursementType(int reimbTypeId, String reimbType) {
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}

    public ReimbursementType() {

    }

    public int getReimbTypeId() {
		return reimbTypeId;
	}


	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}


	public String getReimbType() {
		return reimbType;
	}


	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}


	@Override
	public String toString() {
		return "ReimbursementType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}
		
}
