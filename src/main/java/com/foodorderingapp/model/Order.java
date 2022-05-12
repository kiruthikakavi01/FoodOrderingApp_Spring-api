//package com.foodorderingapp.model;
//
//import java.time.LocalDate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.Data;
//import lombok.ToString;
//
//@Data
//@ToString
//@Entity
//@Table(name = "order")
//public class Order {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//	@Column(name = "user_id")
//	private Integer userId;
//	@Column(name = "dish_id")
//	private Integer dishId;
//	@Column(name = "order_placed_on")
//	private LocalDate date;
//	@Column(name = "address")
//	private String address;
//	@Column(name = "price")
//	private Integer price;
//	@Column(name = "payment_mode")
//	private String paymentMode;
//	@Column(name = "status")
//	private String status;
//}
