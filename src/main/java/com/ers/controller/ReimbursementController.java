package com.ers.controller;


import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.models.Reimbursement;
import com.ers.service.ReimbursementService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementController {

	private ObjectMapper om = new ObjectMapper();
	private ReimbursementService rServ;

	public ReimbursementController(ReimbursementService rServ) {
		super();
		this.rServ = rServ;
	}

	
	public ReimbursementController() {
		this(new ReimbursementService());	
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