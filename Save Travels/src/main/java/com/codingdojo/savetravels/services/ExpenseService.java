package com.codingdojo.savetravels.services;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.ExpenseModel;
import com.codingdojo.savetravels.repositories.ExpenseRepository;


	@Service
	public class ExpenseService {
	 // adding the book repository as a dependency
	 private final ExpenseRepository expenseRepository;
	 
	 public ExpenseService(ExpenseRepository expenseRepository) {
	     this.expenseRepository = expenseRepository;
	 }
	 // returns all the books
	 public List<ExpenseModel> allExpenses() {
	     return expenseRepository.findAll();
	 }
	 // creates a book
	 public ExpenseModel createExpense(ExpenseModel expense) {
	     return expenseRepository.save(expense);
	 }
	 // retrieves a book
	 public ExpenseModel findExpense(Long id) {
	     Optional<ExpenseModel> optionalExpense = expenseRepository.findById(id);
	     if(optionalExpense.isPresent()) {
	         return optionalExpense.get();
	     } else {
	         return null;
	     }
	 }
//	public ExpenseModel updateExpense(ExpenseModel expense) {
//		// TODO Auto-generated method stub
//		return expenseRepository.save(expense);
//	}
	public void deleteExpense(Long id) {
		// TODO Auto-generated method stub
		expenseRepository.deleteById(id);
		
	}

}
