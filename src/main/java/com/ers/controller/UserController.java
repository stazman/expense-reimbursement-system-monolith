package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import com.ers.models.User;
import com.ers.service.UserService;

public class UserController {

	private UserService uServ;

	public UserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}

	public UserController() {
		this(new UserService());
	}

	public String login(HttpServletRequest req) {
		return null;
	}

//	public String login(HttpServletRequest req) {
//		String userName = req.getParameter("name");
//		User u = uServ.findByUsername(User u);
//		if(u != null) {
//			return "html/monster.html";
//		} else {
//			return "html/landing.html";
//		}
//	}
}
