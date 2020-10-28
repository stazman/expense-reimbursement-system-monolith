package com.ers.service;

import com.ers.models.User;
import com.ers.dao.DAOControl;
import com.ers.dao.UserDAOInterface;
import com.ers.dao.UserDAO;

public class UserService {

	private DAOControl<User, Integer> uDao;
	private UserDAOInterface udi;

	public UserService(DAOControl<User, Integer> uDao) {
		super();
		this.uDao = uDao;
	}

	public UserService() {
		this(new UserDAO());
	}

	public User findById(Integer id) {
		return udi.findById(id);
	}

//	public User findByUsername(User u) {
//		return udi.getUserByUsername();
//	}

//	public Set<User> findAll() {
//		return uDao.findAll();
//	}

	public int save(User u) {
		return uDao.create(u);
	}

}