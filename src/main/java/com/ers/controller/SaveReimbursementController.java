package com.ers.controller;

import com.ers.models.Reimbursement;
import com.ers.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SaveReimbursementController {

	private ReimbursementService rServ;

//	public SaveReimbursementController() {
//		this(new ReimbursementService);
//	}

	public SaveReimbursementController(ReimbursementService uServ) {
		super();
		this.rServ = uServ;
	}

	public void saveUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			Reimbursement r = new ObjectMapper().readValue(req.getInputStream(), Reimbursement.class);
			System.out.println(r);
			int uResult = rServ.save(r);
			res.getWriter().println("the monster is added");
		} catch (IOException e) {
			e.printStackTrace();
			res.getWriter().println("something went wrong");
		}
	}
}