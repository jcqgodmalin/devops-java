package com.accenture.ws;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.ws.controller.OrderAndBillingController;
import com.accenture.ws.entity.Order;
import com.accenture.ws.repository.OrderRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderAndBillingTest {
	
	@Autowired
	private OrderAndBillingController controller;
	@Autowired
	private OrderRepository orderRepository;
	
	private Order order;

	@Test
	@org.junit.jupiter.api.Order(4)
	void getOrderListTest() {
		//getOrderListTest
		
		//get all orders from db
		List<Order> orders = controller.getOrderList();
		assertTrue(orders.containsAll(this.controller.getOrderList()));
		
	}
	
	@Test
	@org.junit.jupiter.api.Order(1)
	void addOrderTest() {
		//addOrderTest
		
		Order sampleOrder = new Order("Café Latte",3.5,true);
		controller.addOrder(sampleOrder);
		
		this.order = orderRepository.findTopByOrderByIdDesc();
		
		assertTrue(sampleOrder.equals(this.order));
		
	}
	
	@Test
	@org.junit.jupiter.api.Order(2)
	void updateOrderTest() {
		//updateOrderTest
		
		this.order = orderRepository.findTopByOrderByIdDesc();
		
		this.order.setOrderName("Café Mocha");
		this.order.setPrice(3.5);
		this.order.setIsDiscounted(false);
		
		
		controller.updateOrder(this.order);
		
		List<Order> orders = this.controller.getOrderList();
		
		assertTrue(orders.contains(this.order));
		
	}
	
	@Test
	@org.junit.jupiter.api.Order(3)
	void deleteOrderTest() {
		//deleteOrderTest
		
		this.order = orderRepository.findTopByOrderByIdDesc();
		
		controller.deleteOder(this.order);
		
		List<Order> orders = this.controller.getOrderList();
		
		assertFalse(orders.contains(this.order));
	}

}
