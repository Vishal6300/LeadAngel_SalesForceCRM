package com.crm.leadAngel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.leadAngel.model.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
	
	
}
