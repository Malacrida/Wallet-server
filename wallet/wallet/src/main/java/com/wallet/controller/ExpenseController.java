package com.wallet.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.model.Expense;
import com.wallet.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);
	
	private ExpenseService expenseService;
	
	@Autowired
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@CrossOrigin
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> findExpenses(){

		Map<String, Object> result = new HashMap<String, Object>();

		try {
			result.put("expenses", expenseService.findExpense());
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> addExpenses(@RequestBody Expense expense){
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			expenseService.insertExpense(expense);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return ResponseEntity.ok(result);
	}
	
	@CrossOrigin
	@PostMapping("/remove")
	public ResponseEntity<Map<String, Object>> removeExpenses(@RequestBody Expense expense){
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			expenseService.deleteExpense(expense);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return ResponseEntity.ok(result);
	}
}
