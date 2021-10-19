package com.accenture.ws.entity;

import java.util.List;

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
