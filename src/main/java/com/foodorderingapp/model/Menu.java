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
@Table(name="menu")
public class Menu {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="id")
    private int id;
	@Column(name="Dish_Name",nullable=false,length=100)
	private String dishName;
	@Column(name="Dish_Type",nullable=false,length=100)
	private String dishType;
	@Column(name="Price",nullable=false)
	private int price;
	@Column(name="Hotel_Name",nullable=false,length=100)
	private  String hotelName;
	
}
