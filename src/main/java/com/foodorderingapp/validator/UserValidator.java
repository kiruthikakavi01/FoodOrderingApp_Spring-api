package com.foodorderingapp.validator;

import org.springframework.stereotype.Component;

import com.foodorderingapp.model.User;
@Component
public class UserValidator {
	
public void userValidation(User user) throws Exception {
	if(user.getName() == null||(user.getName()).trim()=="") {
		throw new Exception("Invalid Name");
	}
	else if(user.getEmail()== null|| user.getEmail().trim()==""||!(user.getEmail()).contains("@gmail.com")) {
		throw new Exception("Invalid Email");
	}
	//else if((user.getContactNumber()!=0000000000&&user.getContactNumber()!=999999999)){
		//throw new Exception("Invalid Contact number: pls..declare the 10 digit");
	//}
	else if(user.getPassword()==null||user.getPassword().trim()=="") {
		throw new Exception("Invalid password");
	}
	else if(user.getPassword().length()<9 || user.getPassword().length()>16) {
		throw new Exception("Password must be min 8 digit/max16 digit");
	}
}

public void loginValidation(User user) throws Exception {
	if(user.getEmail()==null||!(user.getEmail()).contains("@gmail.com")) {
		throw new Exception("Invalid email/password");
	}
	else if(user.getPassword()==null||user.getPassword().trim()=="") {
		throw new Exception("Invalid email/password");
	}
	
}
}
