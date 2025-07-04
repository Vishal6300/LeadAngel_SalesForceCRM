package com.crm.leadAngel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.leadAngel.model.Rule;
import com.crm.leadAngel.repository.RuleRepository;

@RestController
@RequestMapping("/rules")
public class RuleController {
	
	
    @Autowired 
    private RuleRepository ruleRepo;
    
    @PostMapping("/add")
    public Rule createRule(@RequestBody Rule rule) {
        return ruleRepo.save(rule);
    }
}