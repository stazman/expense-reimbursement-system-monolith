package com.ers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ers.models.User;
import com.ers.service.UserService;


public class SaveUserController {

	private UserService uServ;

	public SaveUserController() {
		this(new UserService());
	}

	public SaveUserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}

	public void saveUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			User u = new ObjectMapper().readValue(req.getInputStream(), User.class);
			System.out.println(u);
			int uResult = uServ.save(u);
			res.getWriter().println("the monster is added");
		} catch (IOException e) {
			e.printStackTrace();
			res.getWriter().println("something went wrong");
		}
	}
}