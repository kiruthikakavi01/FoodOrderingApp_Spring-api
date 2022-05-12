package com.foodorderingapp.service;



import java.util.List;
import java.util.Optional;

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
	public String update(Integer id,Menu menu) throws Exception {
		
		try {
			menu.setId(id);
			menuValidator.menuValidation(menu);
			menuRepository.save(menu);
			return "success";
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}
	public Menu findById(Integer id) {
		
		Optional<Menu> menu = menuRepository.findById(id);
		if (menu.isPresent()) {
			Menu menuObj = menu.get();
			return menuObj;
		} else {
			return null;
		}
	}
	public void deleteById(Integer id) throws Exception {
		try {
		menuRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Menu> findByName(String dishName) {
		List<Menu> menu = menuRepository.findAll();
		//List<Menu> filteredMenus = menu.stream().filter(m-> m.getDishName().toLowerCase().contains(dishName.toLowerCase())).collect(Collectors.toList());
		List<Menu> filteredMenus = menu.stream().filter(m-> m.getDishName().toLowerCase().contains(dishName.toLowerCase())).toList();
		return filteredMenus;
	}
}
