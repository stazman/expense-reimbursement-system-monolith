package com.ers.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.UserController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ers.controller.ReimbursementController;

public class RequestForwarder {
	

	public String routes(HttpServletRequest req) throws JsonParseException, JsonMappingException, IOException {
		switch (req.getRequestURI()){
		case "/com-ers/login.page":
			return new UserController().login(req);
		case "/com-ers/logout.page":
			return new UserController().logout(req);
		default: 
			return "html/landing.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/com-ers/allReimbursements.json":
			new ReimbursementController().sendAllData(req, res);
			break;
		
		default :
			new UserController().redirectUser(req);
		}
	}

}
