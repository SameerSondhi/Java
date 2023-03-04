package com.codingdojo.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookclub.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    
    Optional<UserModel> findByEmail(String email);
    
    List<UserModel> findAll();
    
}