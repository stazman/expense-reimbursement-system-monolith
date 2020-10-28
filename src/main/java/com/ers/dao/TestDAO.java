package com.ers.dao;

import com.ers.models.*;

import java.util.Set;

public class TestDAO {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		ReimbursementDAO rd = new ReimbursementDAO();

		Set<Reimbursement> rSet = rd.findByStatus("Approved");

		for (Reimbursement r: rSet){
		    System.out.println(r);
        }


		//Test Commit
	}
}

