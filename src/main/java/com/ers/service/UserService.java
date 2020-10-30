package com.ers.service;

import com.ers.models.Reimbursement;
import com.ers.models.User;

import java.util.Set;

import com.ers.dao.UserDAOInterface;

public class UserService {

	private UserDAOInterface udi;

	public UserService(UserDAOInterface udi) {
		super();
		this.udi = udi;
	}
	
	public User validateUser(String username, String password) {
		return udi.checkUsernamePassword(username, password);
	}

	public User findById(Integer id) {
		return udi.findById(id);
	}
	
	public Set<Reimbursement> findReimbursementsByUserId(int userId)  {
		return udi.findReimbursementsByUserId(userId);
	}
	
}