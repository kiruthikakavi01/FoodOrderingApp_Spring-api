package com.foodorderingapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodorderingapp.model.Menu;


public interface MenuRepository extends JpaRepository<Menu,Integer> {
//@Query("select u.* from Menu u where u.dishType like '%?%'")
//void hdhs();
	//@Query/(select u form Menu u where dishName like %?1%)
	//List<Menu> findByName(String dishName);
}
