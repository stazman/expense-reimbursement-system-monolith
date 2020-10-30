package com.ers.dao;


import java.util.Set;

import com.ers.models.Reimbursement;
import com.ers.models.User;
import com.ers.models.UserRole;


public class TestDAO {

	public static void main(String[] args) {

		//First case
//		
//		ReimbursementDAO rd = new ReimbursementDAO();
//
//		Set<Reimbursement> rSet = rd.findAll();
//
//		for (Reimbursement r: rSet){
//		    System.out.println(r);
//        }
		
		//Second case
		
		UserDAO ud = new UserDAO();
		
		UserRole ur = new UserRole(2, "Employee");
		
		User u = new User(13, "ff", "ff", "ff", "ff", "ff", ur);

			
		System.out.println(ud.create(u));


	}

}
