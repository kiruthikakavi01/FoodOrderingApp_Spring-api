//package com.foodorderingapp.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.foodorderingapp.dao.OrderRepository;
//import com.foodorderingapp.model.Order;
//
//
//
//@Service
//public class OrderService {
//	@Autowired
//	OrderRepository orderRepository;
//	
//	public void save(Order order) throws Exception {
//		try {
//		
//		orderRepository.save(order);
//		}
//		catch(Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//	public List<Order> findAll() throws Exception{
//		List<Order> listOrder=null;
//		try {
//			listOrder=orderRepository.findAll();
//		}catch(Exception e) {
//			throw new Exception(e.getMessage());
//		}
//		return listOrder;	
//	}
//	public void update(Integer id,Order order) throws Exception {
//		try {
//			order.setId(id);
//			orderRepository.save(order);
//		}catch(Exception e) {
//			
//			throw new Exception(e.getMessage());
//		}
//	}
//	public Order findById(Integer id) {
//		Optional<Order> dish=orderRepository.findById(id);
//		if(dish.isPresent()) {
//			return dish.get();
//		}else {
//		return null;
//		}
//	}
//}
