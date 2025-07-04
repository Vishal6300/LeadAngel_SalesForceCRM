package com.crm.leadAngel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crm.leadAngel.dto.ResponseDTO;
import com.crm.leadAngel.model.SalesRep;
import com.crm.leadAngel.repository.SalesRepRepository;

@Service
public class SalesRepService {
	
    @Autowired 
    private SalesRepRepository salesRepRepo;

    public ResponseEntity<Object> createSalesRep(SalesRep rep) {
    	try{
    		rep.setCreatedAt(LocalDateTime.now());
            return new ResponseEntity<>(salesRepRepo.save(rep), HttpStatus.OK);
        }catch(Exception e){
            ResponseDTO response= new ResponseDTO();
            response.setMessage("An error Occured.");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
       
    }

    public ResponseEntity<Object> getAllSalesReps() {
    	try{
            return new ResponseEntity<>(salesRepRepo.findAll(), HttpStatus.OK);
        }catch(Exception e){
            ResponseDTO response= new ResponseDTO();
            response.setMessage("No SalesRep found");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
       
    }

    public ResponseEntity<Object> getSalesRepById(Long id) {
    	try{
            return new ResponseEntity<>(salesRepRepo.findById(id), HttpStatus.OK);
        }catch(Exception e){
            ResponseDTO response= new ResponseDTO();
            response.setMessage("No SalesRep found");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }
}