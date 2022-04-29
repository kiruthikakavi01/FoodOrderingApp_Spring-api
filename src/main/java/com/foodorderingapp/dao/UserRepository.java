package com.foodorderingapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodorderingapp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
// @Transactional
// @Modifying
// @Query("update User u set u.password=:password where u.id=:id")
// void changePassword(@Param("id") Integer id,@Param("password") String password);
 
 //User findByEmailAndPassword(String email, String password);
}
