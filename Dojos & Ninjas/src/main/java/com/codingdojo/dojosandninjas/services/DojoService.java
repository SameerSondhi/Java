package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;

import com.codingdojo.dojosandninjas.repositories.DojoRepository;


@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	 public DojoService(DojoRepository dojoRepository) {
	     this.dojoRepository = dojoRepository;
	 }
	 
	 public List<Dojo> allDojos() {
	     return dojoRepository.findAll();
	 }
	 // creates a book
	 public Dojo createDojo(Dojo dojo) {
	     return dojoRepository.save(dojo);
}
	 
	 public Dojo singleDojo(Long id) {
			Optional<Dojo> dojo = dojoRepository.findById(id);
			if(dojo.isPresent()) {
				return dojo.get();
			}
			else {
				return null;
			}
		}
}