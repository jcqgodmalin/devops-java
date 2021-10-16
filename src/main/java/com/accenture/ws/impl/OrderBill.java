package com.accenture.ws.impl;

import java.util.List;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;

public abstract class OrderBill {
	
	protected List<Order> orderList;
	private CafeClerk clerk;
	
	public OrderBill(CafeClerk clerk) {
		this.clerk = clerk;
	}
	
	public CafeClerk getClerk() {
		return this.clerk;
	}
	
	public List<Order> getOrderList(){
		return this.orderList;
	}
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public double getTotalBill() {
		
		double total = 0;
		
		for(Order orders : this.orderList) {
			total += orders.getPrice();
		}
		
		return total;
		
	}
	
}
