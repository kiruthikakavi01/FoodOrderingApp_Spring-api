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

import com.foodorderingapp.dao.MenuRepository;
import com.foodorderingapp.model.Menu;
import com.foodorderingapp.model.User;

@RestController
public class MenuController {
@Autowired
MenuRepository menuRepository;
@PostMapping("dishes/save")
public void save(@RequestBody Menu menu) {
	menuRepository.save(menu);
}
@DeleteMapping("dishes/{id}")
public void delete(@PathVariable("id") Integer id) {
	menuRepository.deleteById(id);
}
@PutMapping("dishes/{id}")//Update User Data
public void update(@PathVariable("id") Integer id,@RequestBody Menu menu) {
	menu.setId(id);
	menuRepository.save(menu);
}
@GetMapping("dishes/{id}")  // find by user Id
public Menu findById(@PathVariable("id") Integer id) {
	Optional<Menu> menu=menuRepository.findById(id);
	if(menu.isPresent()) {
		Menu menuObj=menu.get();
		return menuObj;
	}
	else {
		return null;
	}
	
}
/*@GetMapping("dishes")
public List<Menu> findAll(@RequestParam String dishName){
	return menuRepository.findByName(dishName);
	
}*/
}
