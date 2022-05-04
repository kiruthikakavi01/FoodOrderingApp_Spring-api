package com.foodorderingapp.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodorderingapp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);
// @Transactional
// @Modifying
// @Query("update User u set u.password=:password where u.id=:id")
// void changePassword(@Param("id") Integer id,@Param("password") String password);
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
 
 //public User findByResetPasswordToken(String token);
}
