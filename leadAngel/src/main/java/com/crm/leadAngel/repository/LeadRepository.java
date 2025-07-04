package com.crm.leadAngel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.leadAngel.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
	
}
 