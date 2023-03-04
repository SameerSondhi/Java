package com.codingdojo.bookclub.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.codingdojo.bookclub.models.BookModel;


public interface BookRepository extends CrudRepository<BookModel, Long >{
	List <BookModel>findAll();
	
}
