package com.crm.leadAngel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.leadAngel.model.SalesRep;
import com.crm.leadAngel.service.SalesRepService;

@RestController
@RequestMapping("/sales-reps")
public class SalesRepController {
	
    @Autowired 
    private SalesRepService salesRepService;

    @PostMapping("/add")
    public ResponseEntity<Object> createSalesRep(@RequestBody SalesRep rep) {
        return ResponseEntity.ok(salesRepService.createSalesRep(rep));
    }

    @GetMapping("/getAllSalesReps")
    public ResponseEntity<Object> getAllSalesReps() {
        return salesRepService.getAllSalesReps();
    }

    @GetMapping("/getSalesRepById/{id}")
    public ResponseEntity<Object> getSalesRepById(@PathVariable Long id) {
        return salesRepService.getSalesRepById(id);
    }

}