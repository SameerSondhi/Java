package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.UserModel;
import com.codingdojo.bookclub.repositories.UserRepository;
    
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	public UserModel createUser(UserModel user) {
		  return userRepo.save(user);
	  }

	// TO-DO: Write register and login methods!
	public UserModel register(UserModel newUser, BindingResult result) {
		//Firstly check if there's a user existing with the email put in for registration
		Optional<UserModel> optionaluser = userRepo.findByEmail(newUser.getEmail());

		//If such user exist pass in an error message to binding result
		if (optionaluser.isPresent()) {
			result.rejectValue("email", "unique", "This email already exists");
		}

		//compare user's registration password with confirm password
		//if there's a mismatch insert an error message to binding result
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Your password does not match");
		}

		//If errors exist return null
		if (result.hasErrors()) {
			return null;
		}

		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());

		// Set the password
		newUser.setPassword(hashed);

		userRepo.save(newUser);

		return newUser;
	}

	public UserModel login(LoginUser loginUser, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<UserModel> optionaluser = userRepo.findByEmail(loginUser.getEmail());

		//check if user's email exists otherwise return null
		if (!optionaluser.isPresent()) {
			result.rejectValue("email", "unavailable", "This email has not yet been registered");
			return null;
		}
		
		//Get the user record
		UserModel user = optionaluser.get();
		
		//Check if loginUser password match user password in database
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "matches", "Wrong password! Please try again!");
    	}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	
	//Find all users
	  public List<UserModel> findAllUsers() {
		  return userRepo.findAll();
	  }
	  
	  
	 //Find one user by email
	  public UserModel findByEmail(String email) {
			Optional<UserModel> optionalUser = userRepo.findByEmail(email);
			if(optionalUser.isPresent()) {
				return optionalUser.get();
			}else {
				return null;
			}
		}

	//Find one user by id
	public UserModel findById(Long id) {
	Optional<UserModel> optionalUser = userRepo.findById(id);
	if(optionalUser.isPresent()) {
		return optionalUser.get();
	}else {
		return null;
	}
}
	}
