package com.ers.dao;

import com.ers.models.Reimbursement;
import com.ers.models.User;

import java.util.Set;

public interface UserDAOInterface {

    User getUserByUsername(String username);

    User findById(Integer i);

    Set<Reimbursement> findReimbursementsByUserId (int userId);

	User checkUsernamePassword(String username, String password);

}
