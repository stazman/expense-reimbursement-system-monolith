package com.ers.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ers.models.User;
import com.ers.service.UserService;

public class UserDataController {

	private UserService uServ;

	public UserDataController(UserService uServ) {
		super();
		this.uServ = uServ;
	}

	public UserDataController() {
		this(new UserService());
	}
	
//	public void sendAllData(HttpServletResponse res) {
//		res.setContentType("text/json");
//		Set<User> users = uServ.findAll();
//		try {
//			res.getWriter().println(new ObjectMapper().writeValueAsString(users));
//		} catch (IOException e) {
//		}
//	}

}