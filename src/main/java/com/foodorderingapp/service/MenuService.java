package com.foodorderingapp.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderingapp.dao.MenuRepository;
import com.foodorderingapp.model.Menu;
import com.foodorderingapp.validator.MenuValidator;
@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	MenuValidator menuValidator;

	
	public void save(Menu menu) throws Exception  {
		try {
			menuValidator.menuValidation(menu);
			menuRepository.save(menu);
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
			
		
	}
	public List<Menu> findAll() throws Exception{
		List<Menu> listMenu;
		try {
			listMenu=menuRepository.findAll();	
		}catch(Exception e) {
				throw new Exception(e.getMessage());
		}
		return listMenu;
	}
	public void update(Integer id,Menu menu) throws Exception {
		
		try {
			menu.setId(id);
			menuValidator.menuValidation(menu);
			menuRepository.save(menu);
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}
}
