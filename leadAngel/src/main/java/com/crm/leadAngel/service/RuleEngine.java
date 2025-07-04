package com.crm.leadAngel.service;


import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import com.crm.leadAngel.model.Lead;
import com.crm.leadAngel.model.Rule;
import com.crm.leadAngel.model.SalesRep;
import com.crm.leadAngel.repository.RuleRepository;

@Component
public class RuleEngine {
	
	 @Autowired 
	 private RuleRepository ruleRepo;
	 
	 private final ExpressionParser parser = new SpelExpressionParser();

	    public SalesRep evaluate(Lead lead) {
	        return ruleRepo.findAll().stream()
	            .sorted(Comparator.comparing(Rule::getPriority))
	            .filter(rule -> {
	                EvaluationContext ctx = new StandardEvaluationContext(lead);
	                try {
	                    return parser.parseExpression(rule.getCondition()).getValue(ctx, Boolean.class);
	                } catch (Exception e) {
	                    return false;
	                }
	            })
	            .map(Rule::getSalesRep)
	            .findFirst()
	            .orElse(null);
	    }

	    public Rule addRule(Rule rule) {
	        return ruleRepo.save(rule);
	    }

	    public List<Rule> getAllRules() {
	        return ruleRepo.findAll();
	    }
	} 