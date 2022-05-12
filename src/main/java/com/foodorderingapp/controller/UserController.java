package com.foodorderingapp.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.foodorderingapp.dao.UserRepository;
import com.foodorderingapp.dto.MessageDTO;
import com.foodorderingapp.model.User;
import com.foodorderingapp.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	
	@PostMapping("users/save") // Insert User
	public ResponseEntity<String> register(@RequestBody User user) throws Exception {
		try {
			userService.save(user);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
					
		}

	}

	@DeleteMapping("users/{id}") // Delete User
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			userService.deleteById(id);
			return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("users/{id}") // Update User Data
	public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody User user) {
		try {

			userService.update(id, user);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("users/list") // list user
	public List<User> listUser() {
		List<User> listUser = null;
		try {
			listUser = userService.findAll();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listUser;

	}

	@GetMapping("users/{id}") // find by user Id
	public User findById(@PathVariable("id") Integer id) {
		User user = userService.findById(id);
		return user;

	}

	@PostMapping("users/login")
	public MessageDTO login(@RequestBody User user) {
		MessageDTO message = new MessageDTO();
		try {
			String res = userService.login(user);
			
			message.setMessage(res);
				return message;
			
		} catch (Exception e) {
			message.setMessage(e.getMessage());
			return message;
		}
	}

	@GetMapping("users/email")
	public User getUserByEmail(@RequestParam("email") String email) {

		try {
			return userService.findByEmail(email);
		} catch (Exception e) {
			
			return null;
		}
		

	}

	@PostMapping("users/email")
	public ResponseEntity<String> updatePassword(@RequestParam("email") String email, @RequestBody String password){
		try {
			userService.updateResetPassword(email,password);
			return new ResponseEntity<String>("Password Updated", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	
	}

}
