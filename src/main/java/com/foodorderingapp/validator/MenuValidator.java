package com.foodorderingapp.validator;

import org.springframework.stereotype.Component;

import com.foodorderingapp.model.Menu;
@Component
public class MenuValidator {
	public void menuValidation(Menu menu) throws Exception {
		if(menu.getDishName()==null || (menu.getDishName()).trim()=="") {
			throw new Exception("Invalid Dish Name");
		}
		if(menu.getDishType()==null||(menu.getDishType()).trim()=="") {
			throw new Exception("Invalid Dish Type");
		}
		if(menu.getPrice()==null  || menu.getPrice()<=0) {
			throw new Exception("invalid price");
		}
		if(menu.getHotelName()==null||(menu.getHotelName()).trim()==""){
			throw new Exception("invalid hotel name");
		}
		
		
	}
}
