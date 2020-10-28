package com.ers.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.UserController;
import com.ers.controller.UserDataController;
import com.ers.controller.SaveUserController;

public class RequestForwarder {
	
	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "/expense-reimbursement-system/login.page":
			return new UserController().login(req);
		default: 
			return "html/login.html";
		}
	}
	
//	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		switch(req.getRequestURI()) {
//		case "/expense-reimbursement-system/all.json":
//			new UserDataController().sendAllData(res);
//			break;
//		case "/expense-reimbursement-system/user.json":
//			new SaveUserController().saveUser(req, res);
//			break;
//		}
//	}

}
