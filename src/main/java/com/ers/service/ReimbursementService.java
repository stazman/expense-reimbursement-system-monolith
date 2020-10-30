package com.ers.service;

import com.ers.models.Reimbursement;
import com.ers.dao.DAOControl;
import com.ers.dao.ReimbursementDAOInterface;
import java.util.Set;

public class ReimbursementService {

	private DAOControl<Reimbursement, Integer> rDao;
	private ReimbursementDAOInterface rdi;

	public ReimbursementService(DAOControl<Reimbursement, Integer> rDao, ReimbursementDAOInterface rdi) {
		super();
		this.rDao = rDao;
		this.rdi = rdi;
	}

	public Set<Reimbursement> findByStatus(String status) {
		return rdi.findByStatus(status);
	}

	public Set<Reimbursement> findAllReimbursements() {
		return rdi.findAll();
	}

	public int save(Reimbursement r) {
		return rDao.create(r); 
	}
	
	public Reimbursement updateReimbursementStatus(Reimbursement reimb) {
		return rdi.update(reimb);
	}

}
