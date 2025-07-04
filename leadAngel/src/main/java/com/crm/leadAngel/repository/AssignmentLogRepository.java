package com.crm.leadAngel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.leadAngel.model.AssignmentLog;

@Repository
public interface AssignmentLogRepository extends JpaRepository<AssignmentLog, Long> {

	List<AssignmentLog> findBySyncedToCrmFalse();
	
}
