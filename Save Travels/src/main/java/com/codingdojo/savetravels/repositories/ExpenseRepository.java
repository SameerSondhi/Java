package com.codingdojo.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.savetravels.models.ExpenseModel;


@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseModel, Long> {
	 List<ExpenseModel> findAll();

}
