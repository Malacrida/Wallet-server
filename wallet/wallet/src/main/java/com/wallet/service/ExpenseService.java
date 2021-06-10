package com.wallet.service;

import java.util.List;

import com.wallet.model.Expense;

public interface ExpenseService {

	List<Expense> findExpense();

	void insertExpense(Expense expense);

	void deleteExpense(Expense expense);

}
