package com.crm.leadAngel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.crm.leadAngel.model.AssignmentLog;
import com.crm.leadAngel.model.Lead;
import com.crm.leadAngel.repository.AssignmentLogRepository;

@Service
public class CRMService {
	
    @Autowired 
    private AssignmentLogRepository logRepo;
    
    private final WebClient webClient = WebClient.create("http://localhost:5000/mock-crm");
    // Here 5000 is the server port that I am using currently. We can replace it by actual Salesforce API.
    
    @Scheduled(fixedRate = 5 * 60 * 1000) // checking for 5 minutes now
    @Async
    public void syncAssignedLeads() {
        List<AssignmentLog> logs = logRepo.findBySyncedToCrmFalse();

        for (AssignmentLog log : logs) {
            Lead lead = log.getLead();

            webClient.post()
                .uri("/leads")
                .bodyValue(lead)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> {
                    log.setSyncedToCrm(true);
                    logRepo.save(log);
                });
        }
    }
}