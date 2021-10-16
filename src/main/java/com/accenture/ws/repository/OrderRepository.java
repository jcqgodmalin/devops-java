package com.accenture.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.ws.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	public Order findTopByOrderByIdDesc();

}
