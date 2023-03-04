package com.codingdojo.savetravels.controllers;

import java.util.List;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.savetravels.models.ExpenseModel;
import com.codingdojo.savetravels.services.ExpenseService;
//import com.codingdojo.savetravels.services.ExpenseService;


@Controller
public class ExpenseController {
	
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
    public String index(@ModelAttribute("expense") ExpenseModel expense, Model model) {
		List<ExpenseModel> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
        return "homepage.jsp";
    }
	
	
	@PostMapping("/new")
    public String create(@Valid @ModelAttribute("expense") ExpenseModel expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<ExpenseModel> expenses = expenseService.allExpenses();
        	model.addAttribute("expenses", expenses);
            return "homepage.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/";
        }
    }
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
        ExpenseModel expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
	
}
	
	
	//View one expense
	@GetMapping("/expenses/{id}")
	public String details(@ModelAttribute("id") Long id, Model model) {
        ExpenseModel expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "details.jsp";
      
	}
	
	
	
	// process edit form using data binding
		@PutMapping("/expenses/edit/{id}")
		public String editExpense(@Valid @ModelAttribute("expense") ExpenseModel expense, BindingResult result) {

			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				expenseService.createExpense(expense);
				return "redirect:/";
			}

		}
	
	// route to delete a single expense
		@DeleteMapping("/expenses/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	        expenseService.deleteExpense(id);
	        return "redirect:/";
	    }
	
	
}
