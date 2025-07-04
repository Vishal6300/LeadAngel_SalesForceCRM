package com.crm.leadAngel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.leadAngel.model.Lead;
import com.crm.leadAngel.repository.LeadRepository;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
	
    @Autowired 
    private LeadRepository leadRepo;
    
    @GetMapping 
    public List<Lead> getAssignedLeads() {
        return leadRepo.findAll().stream().filter(l -> l.getAssignedTo() != null).toList();
    }
}