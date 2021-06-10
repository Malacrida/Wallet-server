package com.wallet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wallet.model.Expense;

@Mapper
public interface ExpenseMapper {

	List<Expense> findExpense();
	int insertExpense(Expense expense);
	int deleteExpense(Expense expense);
}
