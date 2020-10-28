package com.ers.dao;

import com.ers.models.Reimbursement;

import java.util.Set;

public interface ReimbursementDAOInterface {

    Reimbursement update(Reimbursement reimb);

    Set<Reimbursement> findAll();

    Set<Reimbursement> findByStatus(String status);
}
