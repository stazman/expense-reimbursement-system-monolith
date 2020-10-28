package com.ers.controller;

import java.io.IOException;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ers.models.Reimbursement;
import com.ers.service.ReimbursementService;

public class ReimbursementDataController {

	private ReimbursementService rServ;

	public ReimbursementDataController(ReimbursementService rServ) {
		super();
		this.rServ = rServ;
	}

	public ReimbursementDataController() {
		this(new ReimbursementService());
	}
	
	public void sendAllData(HttpServletResponse res) {
		res.setContentType("text/json");
		Set<Reimbursement> reimbs = rServ.findAll();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reimbs));
		} catch (IOException e) {
		}
	}
}
