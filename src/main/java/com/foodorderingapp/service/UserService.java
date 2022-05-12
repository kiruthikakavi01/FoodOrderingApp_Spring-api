package com.foodorderingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderingapp.dao.UserRepository;
import com.foodorderingapp.model.User;
import com.foodorderingapp.validator.UserValidator;

@Service
public class UserService {
@Autowired
UserRepository userRepository;
@Autowired
UserValidator userValidator;
public void save(User user) throws Exception {
	try {
	userValidator.userValidation(user);
	userRepository.save(user);
	}
	catch(Exception e) {
		throw new Exception(e.getMessage());
	}
}
public List<User> findAll() throws Exception{
	List<User> listUser=null;
	try {
		listUser=userRepository.findAll();
	}catch(Exception e) {
		throw new Exception(e.getMessage());
	}
	return listUser;
	
}
public void update(Integer id,User user) throws Exception {
	try {
		user.setId(id);
		userValidator.userValidation(user);
		userRepository.save(user);
	}catch(Exception e) {
		
		throw new Exception(e.getMessage());
	}
}
public User findById(Integer id) {
	Optional<User> user=userRepository.findById(id);
	if(user.isPresent()) {
		return user.get();
	}else {
	return null;
	}
}
public void deleteById(Integer id) throws Exception {
	try {
		userRepository.deleteById(id);
	}catch(Exception e) {
		throw new Exception(e.getMessage());
	}
}
public String  login(User user) throws Exception {
	try {
		//userValidator.loginValidation(user);
		Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		System.out.println(userObj);
		if (userObj.isPresent()) {
			return "success";
		} else {
			return null;
		}

	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
}
public void updateResetPassword(String email,String password) throws Exception {
	User user = userRepository.findByEmail(email);
	System.out.println(user);

	if(user != null) {
		
		try {
			if(password.length()>=8&&password.length()<=16) {
				user.setPassword(password);
			    userRepository.save(user);
			}
			else
				throw new Exception("Password must be min 8 digit/max16 digit");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	} else {
		throw new Exception("Could not find any customer with email");
	}
}
public User findByEmail(String email) throws Exception {
	try {
	return userRepository.findByEmail(email);
	}catch(Exception e) {
		throw new Exception("could not find user");
	}
}


}
