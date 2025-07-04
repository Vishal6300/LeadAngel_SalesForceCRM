package com.crm.leadAngel.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssignmentLog {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private Lead lead;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    private LocalDateTime assignedAt;
    private boolean syncedToCrm;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
	}
	public SalesRep getSalesRep() {
		return salesRep;
	}
	public void setSalesRep(SalesRep salesRep) {
		this.salesRep = salesRep;
	}
	public LocalDateTime getAssignedAt() {
		return assignedAt;
	}
	public void setAssignedAt(LocalDateTime assignedAt) {
		this.assignedAt = assignedAt;
	}
	public boolean isSyncedToCrm() {
		return syncedToCrm;
	}
	public void setSyncedToCrm(boolean syncedToCrm) {
		this.syncedToCrm = syncedToCrm;
	}
	public AssignmentLog(Long id, Lead lead, SalesRep salesRep, LocalDateTime assignedAt, boolean syncedToCrm) {
		super();
		this.id = id;
		this.lead = lead;
		this.salesRep = salesRep;
		this.assignedAt = assignedAt;
		this.syncedToCrm = syncedToCrm;
	}
	public AssignmentLog() {
		
	}

    
}
