package com.ers.controller;


import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.models.Reimbursement;
import com.ers.models.User;
import com.ers.service.ReimbursementService;
import com.ers.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ers.models.Reimbursement;
import com.ers.service.ReimbursementService;

public class ReimbursementController {

	private ObjectMapper om = new ObjectMapper();
	private UserService uServ;
	private ReimbursementService rServ;

	public ReimbursementController(ReimbursementService rServ, UserService uServ) {
		super();
		this.uServ = uServ;
		this.rServ = rServ;
	}

	
	public ReimbursementController() {
		// TODO Auto-generated constructor stub
	}


	public void sendAllDataByStatus(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
				
		String status =  req.getParameter("reimbStatus");
		Set<Reimbursement> reimbs = rServ.findByStatus(status);
		res.getWriter().write(om.writeValueAsString(reimbs));
		
	}

	public void sendAllData(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Set<Reimbursement> reimbs = rServ.findAllReimbursements();
		res.getWriter().write(om.writeValueAsString(reimbs));
		
		
	}

	public void updateReimbursementStatus(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		
		
		
	}
	
}