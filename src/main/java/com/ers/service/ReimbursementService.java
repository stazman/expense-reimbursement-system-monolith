package com.ers.service;

import com.ers.models.Reimbursement;
import com.ers.dao.DAOControl;
import com.ers.dao.ReimbursementDAO;
import com.ers.dao.ReimbursementDAOInterface;
import java.util.Set;

public class ReimbursementService {

	private DAOControl<Reimbursement, Integer> rDao;
	private ReimbursementDAOInterface rdi;

	public ReimbursementService(DAOControl<Reimbursement, Integer> rDao) {
		super();
		this.rDao = rDao;
	}

	public ReimbursementService() {
		this(new ReimbursementDAO());
	}

	public Set<Reimbursement> findByStatus(String status) {
		return rdi.findByStatus(status);
	}

	public Set<Reimbursement> findAll() {
		return rdi.findAll();
	}

	public int save(Reimbursement r) {
		return rDao.create(r); }

}
