package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import com.ers.dao.UserDAOInterface;
import com.ers.models.User;
import com.ers.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {

	ObjectMapper om = new ObjectMapper();
	User u = new User();
	
	private UserService uServ;

	public UserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}

	public UserController() {
		this(new UserService());
	}

	public String redirectUser(HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("user");
		if (u.getRole().getUserRole().equals("employee")) {
			return "html/empl.html";
		} else {
			return "html/landing.html";
		}
	}
	
	public String login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User u = uServ.validateUser(username, password);
			if(u == null ) {
				return "landing.page";
			} else {
				req.getSession().setAttribute("user", u);
				return redirectUser(req);
			}
	}

	public String logout(HttpServletRequest req) {
		return null;
	}

}


