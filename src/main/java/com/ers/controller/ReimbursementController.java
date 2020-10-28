package com.ers.controller;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.ers.models.Reimbursement;
import com.ers.service.ReimbursementService;
import com.ers.models.Reimbursement;
import com.ers.service.ReimbursementService;

public class ReimbursementController {

	private ReimbursementService rServ;

	public ReimbursementController(ReimbursementService rServ) {
		super();
		this.rServ = rServ;
	}

	public ReimbursementController() {
		this(new ReimbursementService());
	}

	}