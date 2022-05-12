//package com.foodorderingapp.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.foodorderingapp.dao.OrderRepository;
//import com.foodorderingapp.model.Order;
//import com.foodorderingapp.service.OrderService;
//
//@RestController
//public class OrderController {
//	@Autowired
//	OrderRepository orderRepository;
//	@Autowired
//	OrderService orderService;
//	
//	@PostMapping("order/save")
//	public ResponseEntity<String> register(@RequestBody Order order) {
//		try {
//			orderService.save(order);
//			return new ResponseEntity<String>("Successfully Ordered",HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		}
//
//	}
//	@PutMapping("users/{id}")//Update User Data
//	public ResponseEntity<String> update(@PathVariable("id") Integer id,@RequestBody Order order) {
//		try {
//		
//		orderService.update(id,order);
//		return new ResponseEntity<String>("success",HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		}
//	}
//	@GetMapping("order/list")
//	public List<Order> listOrder(){
//		List<Order> listOrder=null;
//		try {
//	        listOrder=orderService.findAll();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		return listOrder;
//		
//	}
//	@GetMapping("order/{id}")
//	public Order findById(Integer id) {
//		Order order=orderService.findById(id);
//		return order;
//		
//	}
//
//}
