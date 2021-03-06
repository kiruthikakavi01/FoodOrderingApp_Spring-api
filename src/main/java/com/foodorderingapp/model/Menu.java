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
    private Integer id;
	@Column(name="Dish_Name",nullable=false,length=100)
	private String dishName;
	@Column(name="Dish_Type",nullable=false,length=100)
	private String dishType;
	@Column(name="Price",nullable=false)
	private Integer price;
	@Column(name="Hotel_Name",nullable=false,length=100)
	private  String hotelName;
	@Column(name="image_url",nullable=false,length=50)
	private String imageUrl;
	
	@Column(name="Ingredients",nullable=false,length=1000)
	private String ingredients;
	
}
