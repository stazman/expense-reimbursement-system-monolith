package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import com.ers.dao.UserDAOInterface;
import com.ers.models.Reimbursement;
import com.ers.models.User;
import com.ers.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {

	ObjectMapper om = new ObjectMapper();
	User u = new User();
	
	private UserService uServ;

	public UserController(UserService uServ) {
		super();
		this.uServ = uServ;
	}

//	public UserController() {
//		this(new UserService());
//	}

	public UserController() {
		// TODO Auto-generated constructor stub
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
	
	public void sendAllDataByUser(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		int userID = user.getUserId();
		Set<Reimbursement> reimbs = uServ.findReimbursementsByUserId(userID);
		res.getWriter().write(om.writeValueAsString(reimbs));
	}

}


