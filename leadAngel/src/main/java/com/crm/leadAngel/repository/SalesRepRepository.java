package com.crm.leadAngel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.leadAngel.model.SalesRep;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

}
