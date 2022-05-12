package com.foodorderingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodorderingapp.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	
	
}
