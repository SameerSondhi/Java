package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.codingdojo.bookclub.models.BookModel;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.UserModel;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService users;

	@Autowired
	private BookService books;

	// DISPLAY FIRST PAGE TO LOGIN OR REGISTER
	// Route to show registration form
	@GetMapping("/")
	public String showRegPage(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			return "books.jsp";
		} else {
			model.addAttribute("newUser", new UserModel());
			model.addAttribute("newLogin", new LoginUser());
			return "loginreg.jsp";
		}

	}

	// Route to show all books and respective users after the user has registered or
	// logged in
	@GetMapping("/books")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("user_id") != null) {
			Long loggedID = (Long) session.getAttribute("user_id");
			UserModel name = users.findById(loggedID);
			List<BookModel> listOfAllBooks = books.returnAllBooks();
			model.addAttribute("allBooks", listOfAllBooks);
			model.addAttribute("loggedUser", name);
			return "books.jsp";

		} else {
			return "redirect:/";

		}
	}
	
	

	// EVERYTHING REGARDING REGISTERING OR LOGGING IN
	// post route for registration matching registration action in form tag in jsp
	// file
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") UserModel newUser, BindingResult result, Model model,
			HttpSession session) {
		users.register(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "loginreg.jsp";
		} else {
			session.setAttribute("user_id", newUser.getId());

			return "redirect:/books";
		}

	}

	// post route for login matching login action in form tag in jsp file
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		UserModel user = users.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new UserModel());
			return "loginreg.jsp";
		} 
			session.setAttribute("user_id", user.getId());
			return "redirect:/books";

	}

	// Log out user
	@GetMapping("/logout")
	public String logOutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
	
	// EVERYTHING REGARDING BOOKS
	// Get request to display new book form
	@GetMapping("/books/new")
	public String showBookForm(Model model, HttpSession session, @ModelAttribute("book") BookModel book) {
		if (session.getAttribute("user_id") != null) {
			Long loggedID = (Long) session.getAttribute("user_id");
			model.addAttribute("loggedUser", loggedID);
			return "bookform.jsp";
		} else {
			return "redirect:/";
		}
	}

	// Post request to process new book form
	@PostMapping("/books/new")
	public String processBookForm(@Valid @ModelAttribute("book") BookModel book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("users", users.findAllUsers());
			return "bookform.jsp";
		} else {
			books.createBook(book);
			return "redirect:/books";
		}
	}

	// get route for getting one book's details
	@GetMapping("/books/{id}")
	public String getOneBook(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("book") BookModel book) {
		BookModel book1 = books.findBook(id);
		Long loggedID = (Long) session.getAttribute("user_id");
		model.addAttribute("loggedUser", loggedID);
		model.addAttribute("book", book1);
		return "bookdetail.jsp";
	}

	
	// Edit a book
	@GetMapping("/books/edit/{id}")
	public String editBook(Model model,HttpSession session, @PathVariable("id")Long id, @ModelAttribute("book") BookModel book) {
		if(session.getAttribute("user_id") != null ) {
			BookModel book1 = books.findBook(id);
			Long loggedID = (Long) session.getAttribute("user_id");
			model.addAttribute("logged",loggedID);
			model.addAttribute("thisBook",book1);
			return "editbook.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/books/edit/{id}")
	public String editBookForm(Model model, @Valid @ModelAttribute("book") BookModel book, BindingResult result) {
		if(result.hasErrors()) {
			return "editbook.jsp";
		}else {			
			books.updateBook(book);
			return "redirect:/books";
		}
	}
	
	// Delete a book and redirect to dash board
	@DeleteMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		books.deleteBook(id);
		return "redirect:/books";
	}
	
	// Borrow a book and redirect to dash board		
		 @GetMapping("/books/borrow/{id}")
		    public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
		    	if(session.getAttribute("user_id") != null) {
		    	BookModel book = books.findBook(id);
		    	book.setBorrower(users.findById((Long)session.getAttribute("user_id")));
		    	books.updateBook(book);
		    	}
		    	return "redirect:/books";
		    }

		 //Return a book and redirect to dashboard
		 @GetMapping("/books/return/{id}")
		    public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		    	if(session.getAttribute("user_id") != null) {
		    	BookModel book = books.findBook(id);
		    	book.setBorrower(null);
		    	books.updateBook(book);
		    	}
		    	return "redirect:/books";
		    }
}

