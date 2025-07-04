package com.crm.leadAngel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.leadAngel.model.Lead;

@RestController
@RequestMapping("/mock-crm")
public class MockCRMController {
	
    @PostMapping("/leads")
    public ResponseEntity<String> acceptLead(@RequestBody Lead lead) {
        return ResponseEntity.ok("Lead synced with CRM: " +lead.getId());
    }
}