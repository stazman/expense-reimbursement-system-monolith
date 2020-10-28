package com.ers.models;

public class Reimbursement {

	private int reimbursementId; // primary key
	private double amount;  // not null
	private String submitted;
	private String resolved;
	private String description;
	private String receipt;
	private User reimbAuthor;
	private User reimbResolver;
	private ReimbursementStatus reimbStatus;
	private ReimbursementType reimbType;


	public Reimbursement(int reimbursementId, double amount, String submitted, String resolved, String description, String receipt, User reimbAuthor, User reimbResolver, ReimbursementStatus reimbStatus, ReimbursementType reimbType) {
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

    public Reimbursement(int i) {
		this.reimbursementId = i;
    }

	public Reimbursement(User eEx2, ReimbursementStatus rs2, int i) {
		this.reimbResolver = eEx2;
		this.reimbStatus = rs2;
		this.reimbursementId = i;
	}

	public Reimbursement() {

	}

	public int getReimbursementId() {
		return reimbursementId;
	}


	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getSubmitted() {
		return submitted;
	}


	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getReceipt() {
		return receipt;
	}


	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}


	public User getReimbAuthor() {
		return reimbAuthor;
	}


	public void setReimbAuthor(User reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}


	public User getReimbResolver() {
		return reimbResolver;
	}


	public void setReimbResolver(User reimbResolver) { this.reimbResolver = reimbResolver; }
	
	public ReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}


	public void setReimbStatus(ReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}


	public ReimbursementType getReimbType() {
		return reimbType;
	}


	public void setReimbType(ReimbursementType reimbType) {
		this.reimbType = reimbType;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", description=" + description + ", receipt=" + receipt + ", reimbAuthor="
				+ reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus + ", reimbType="
				+ reimbType + "]";
	}

}
