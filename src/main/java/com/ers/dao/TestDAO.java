package com.ers.dao;


import java.util.Set;

import com.ers.models.Reimbursement;
import com.ers.dao.ReimbursementDAO;


public class TestDAO {

	public static void main(String[] args) {

		ReimbursementDAO rd = new ReimbursementDAO();

		Set<Reimbursement> rSet = rd.findByStatus("Approved");

		for (Reimbursement r: rSet){
		    System.out.println(r);
        }


		//Test Commit
	}

}
