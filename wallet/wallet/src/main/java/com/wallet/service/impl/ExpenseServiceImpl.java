package com.wallet.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.mapper.ExpenseMapper;
import com.wallet.model.Expense;
import com.wallet.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	private ExpenseMapper expenseMapper;
	
	@Autowired
	public ExpenseServiceImpl(ExpenseMapper expenseMapper) {
		this.expenseMapper = expenseMapper;
	}
	
	@Override
	public List<Expense> findExpense(){
		return expenseMapper.findExpense();
	}
	
	@Override
	public void insertExpense(Expense expense) {
		expense.setId(UUID.randomUUID().toString());
		expenseMapper.insertExpense(expense);
	}
	
	@Override
	public void deleteExpense(Expense expense) {
		expenseMapper.deleteExpense(expense);
	}
}
