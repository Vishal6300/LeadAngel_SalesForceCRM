package com.crm.leadAngel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.leadAngel.model.Lead;
import com.crm.leadAngel.service.LeadService;

@RestController
@RequestMapping("/leads")
public class LeadController {
	
    @Autowired 
    private LeadService leadService;
    
    @PostMapping("/add")
    public Lead createLead(@RequestBody Lead lead) {
//    	System.out.println(lead.getEmail());
        return leadService.createAndRouteLead(lead).join();
    }
}