package com.crm.leadAngel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.leadAngel.service.CRMService;

@RestController
@RequestMapping("/sync")
public class SyncController {
	
    @Autowired 
    private CRMService crmService;
    
    @PostMapping
    public void sync() {
        crmService.syncAssignedLeads();
    }
}