package com.foodorderingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
@Table(name="user_register")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private Integer id;
	@Column(name="Name", nullable=false,length=100)
	private String name;
	@Column(name="email",nullable=false ,unique=true,length=100)
	private String email;
	@Column(name="contact_Number",nullable=false)
	private long contactNumber;
	@Column(name="PASSWORD",nullable=false,length=50)
	private String password;
	
	

}
