package com.crm.leadAngel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.crm.leadAngel.model.AssignmentLog;
import com.crm.leadAngel.model.Lead;
import com.crm.leadAngel.model.SalesRep;
import com.crm.leadAngel.repository.AssignmentLogRepository;
import com.crm.leadAngel.repository.LeadRepository;

@Service
public class LeadService {
	
    @Autowired 
    private LeadRepository leadRepo;
    
    @Autowired 
    private AssignmentLogRepository logRepo;
    
    @Autowired 
    private RuleEngine ruleEngine;

    @Async
    public CompletableFuture<Lead> createAndRouteLead(Lead lead) {  
        Lead savedLead = leadRepo.save(lead);

        SalesRep assignedRep = ruleEngine.evaluate(savedLead);
        if (assignedRep != null) {
            savedLead.setAssignedTo(assignedRep.getName());
            leadRepo.save(savedLead);

            AssignmentLog log = new AssignmentLog();
            log.setLead(savedLead);
            log.setSalesRep(assignedRep);
            log.setAssignedAt(LocalDateTime.now());
            log.setSyncedToCrm(false);
            logRepo.save(log);
        }
        return CompletableFuture.completedFuture(savedLead);
    }

    public List<Lead> getAllLeads() {
        return leadRepo.findAll();
    }
}