package com.ers.dao;

import com.ers.models.User;

public interface UserDAOInterface {

    User getUserByUsername(String username);

    User findById(Integer i);

}
