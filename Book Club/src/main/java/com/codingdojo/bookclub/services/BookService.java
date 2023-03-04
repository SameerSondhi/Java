package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.BookModel;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired BookRepository bookRepo;
	
	//Find all books
	public List<BookModel> returnAllBooks(){
		return bookRepo.findAll();
	}
	
	//Create one book
	public BookModel createBook(BookModel book){
		return bookRepo.save(book);
	}
	
	//Get OR Retrieve one book
	public BookModel findBook(Long id) {
		Optional<BookModel> optionalbook = bookRepo.findById(id);
		if (optionalbook.isPresent()) {
			return optionalbook.get();
		}
		else {
			return null;
		}
	}
	
	//Update a book
	public BookModel updateBook(BookModel book){
		Optional<BookModel> optionalbook = bookRepo.findById(book.getId());
		if (optionalbook.isPresent()) {
			BookModel oneBook = optionalbook.get();
			oneBook.setTitle(book.getTitle());
			oneBook.setAuthor(book.getAuthor());
			oneBook.setDescription(book.getDescription());
			oneBook.setId(book.getId());
			
			return bookRepo.save(book);
		}
		else {
			return null;
		}
	}
	
	
	//Delete a book by id
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
