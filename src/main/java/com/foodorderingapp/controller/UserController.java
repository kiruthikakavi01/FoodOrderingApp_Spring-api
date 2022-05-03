package com.foodorderingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodorderingapp.dao.UserRepository;
import com.foodorderingapp.model.User;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("users/save") // Insert User
	public void save(@RequestBody User user) {
		userRepository.save(user);

	}

	@DeleteMapping("users/{id}") // Delete User
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("users/{id}")//Update User Data
	public void update(@PathVariable("id") Integer id,@RequestBody User user) {
		user.setId(id);
		userRepository.save(user);
	}

	@GetMapping("users/list")  //list user
	public List<User> findAll() {
		List<User> listUser = userRepository.findAll();
		return listUser;

	}
	
	@GetMapping("users/{id}")  // find by user Id
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()) {
			User userObj=user.get();
			return userObj;
		}
		else {
			return null;
		}
	}
	@PostMapping("users/login")
	public User login(@RequestBody User user) {
		Optional<User> userObj=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		if(userObj.isPresent()) {
			return userObj.get();
		}else {
		return null;
		}
		
	}

}
