package com.accenture.ws.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.impl.DiscountedBill;
import com.accenture.ws.impl.RegularBill;
import com.accenture.ws.repository.OrderRepository;

@RestController
@RequestMapping("/api")
@Transactional

//CrossOrigin for dev purposes only.
@CrossOrigin(origins = "http://localhost:4200")
public class OrderAndBillingController {

	
	@Autowired
	private OrderRepository orderRepository;
	
	private CafeClerk clerk = new CafeClerk("Janiboi");
	
	public OrderAndBillingController() {
		//default constructor
	}
	
	/*
	 * 
	 * ORDERS
	 * 
	 */
	
	@GetMapping("/orders")
	public List<Order> getOrderList(){
		
		return this.orderRepository.findAll();
		
	}
	
	@PostMapping("/orders")
	public void addOrder(@RequestBody Order order) {
		
		this.orderRepository.save(order);
		
	}
	
	@PutMapping("/orders")
	public void updateOrder(@RequestBody Order order) {
		
		Order orderForUpdate = orderRepository.getById(order.getId());
		
		orderForUpdate.setOrderName(order.getOrderName());
		orderForUpdate.setPrice(order.getPrice());
		orderForUpdate.setIsDiscounted(order.isDiscounted());
		
		this.orderRepository.save(orderForUpdate);
		
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteOder(@PathVariable long id) {
		
		Order order = this.orderRepository.findById(id).get();
		this.orderRepository.delete(order);
		
	}
	
	
	/*
	 * 
	 * BILLING
	 * 
	 */
	
	@GetMapping("/billing/regular")
	public OrderBill getTotalRegularBill() {
		
		OrderBill orderBill = new RegularBill(this.clerk);
		orderBill.setOrderList(getOrderList());
		return orderBill;
		
	}
	
	@GetMapping("/billing/discounted")
	public OrderBill getTotalDiscountedBill() {
		
		OrderBill orderBill = new DiscountedBill(this.clerk);
		orderBill.setOrderList(getOrderList());
		return orderBill;
		
	}
}
