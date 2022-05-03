package com.foodorderingapp.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.foodorderingapp.model.Menu;


public interface MenuRepository extends JpaRepository<Menu,Integer> {

	//Optional<Menu> findByName(String dishName);

//	@Query("select u from Menu u where u.dishName like '%dishName%'")
//	List<Menu> findByName(String dishName);
	//List<Menu> findByDishNameContaining(String dishName);
}
