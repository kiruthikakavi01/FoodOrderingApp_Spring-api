package com.foodorderingapp.controller;

import java.util.List;
import java.util.Optional;


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

import com.foodorderingapp.dao.MenuRepository;
import com.foodorderingapp.dto.MessageDTO;
import com.foodorderingapp.model.Menu;
import com.foodorderingapp.service.MenuService;


@RestController
public class MenuController {
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	MenuService menuService;
	
	@PostMapping("dishes/save")
	public ResponseEntity<String> addMenu(@RequestBody Menu menu) {
		try {
		menuService.save(menu);
		return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("dishes/list")  
	public List<Menu> listMenu() {
		List<Menu> findAll=null;
		try {
			 findAll=menuService.findAll();
		} catch (Exception e) {	
		e.printStackTrace();
		}
		return findAll;
	}

	@GetMapping("dishes/name/search")
	public List<Menu> findByName(@RequestParam("name") String dishName) {
		
		List<Menu> menu = menuService.findByName(dishName);
		return menu;
	}
	@GetMapping("dishes/type/search")
	public List<Menu> findByType(@RequestParam("type") String dishType){
		System.out.println(dishType);
		List<Menu> menu=menuRepository.findAll();
		List<Menu> filteredMenus=menu.stream().filter(m->m.getDishName().toLowerCase().contains(dishType.toLowerCase())).toList();
		return filteredMenus;
		
	}
	@GetMapping("dishes/{id}") // find by Dish Id
	public Menu findById(@PathVariable("id") Integer id) {
		System.out.println("findById " + id);
		Menu menu= menuService.findById(id);
		return menu;
	}

	
	@DeleteMapping("dishes/{id}")
	public MessageDTO delete(@PathVariable("id") Integer id) {
		MessageDTO message = new MessageDTO();
		try {
			menuService.deleteById(id);
			message.setMessage("success");
			return message;
			
		} catch (Exception e) {
			message.setMessage(e.getMessage());
			return message;
		}
	}

	@PutMapping("dishes/{id}") // Update Menu Data
	public MessageDTO update(@PathVariable("id") Integer id, @RequestBody Menu menu) {
		MessageDTO message = new MessageDTO();
		try {
			String res=menuService.update(id,menu);
			message.setMessage(res);
			
			return message;
		} catch (Exception e) {
			message.setMessage(e.getMessage());
			return message;
			
		}
	}
}
 