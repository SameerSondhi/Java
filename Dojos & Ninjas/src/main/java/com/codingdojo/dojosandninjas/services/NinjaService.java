package com.codingdojo.dojosandninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	 public NinjaService(NinjaRepository ninjaRepository) {
	     this.ninjaRepository = ninjaRepository;
	 }
	 
	 // creates a book
	 public Ninja createNinja(Ninja ninja) {
	     return ninjaRepository.save(ninja);
	 }
	
	 }


