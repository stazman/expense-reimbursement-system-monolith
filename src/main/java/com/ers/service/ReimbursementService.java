package com.ers.service;

import com.ers.models.Reimbursement;
import com.ers.dao.DAOControl;
import com.ers.dao.ReimbursementDAO;
import com.ers.dao.ReimbursementDAOInterface;
import java.util.Set;

public class ReimbursementService {

	private ReimbursementDAO rdi;

	public ReimbursementService(ReimbursementDAO rdi) {
		super();
		this.rdi = rdi;
	}

	public ReimbursementService() {

		this(new ReimbursementDAO());
	}

	public Set<Reimbursement> findByStatus(String status) {
		return rdi.findByStatus(status);
	}

	public Set<Reimbursement> findAllReimbursements() {
		return rdi.findAll();
	}

	public int save(Reimbursement r) {
		return rdi.create(r); 
	}
	
	public Reimbursement updateReimbursementStatus(Reimbursement reimb) {
		return rdi.update(reimb);
	}

}
