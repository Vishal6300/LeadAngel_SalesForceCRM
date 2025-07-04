package com.crm.leadAngel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rule {
    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "rule_condition")
    private String condition;
    private Integer priority;
    
    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;


    
	public SalesRep getSalesRep() {
		return salesRep;
	}
	public void setSalesRep(SalesRep salesRep) {
		this.salesRep = salesRep;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	public Rule(Long id, String condition, Integer priority, SalesRep salesRep) {
		super();
		this.id = id;
		this.condition = condition;
		this.priority = priority;
		this.salesRep = salesRep;
	}
	public Rule() {
		
	}
    
    
}