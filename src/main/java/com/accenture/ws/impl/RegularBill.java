package com.accenture.ws.impl;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;

public class RegularBill extends OrderBill{

	public RegularBill(CafeClerk clerk) {
		super(clerk);
	}
	
	@Override
	public double getTotalBill() {
		double total = 0;
		for(Order orders : this.orderList) {
			total += orders.getPrice();
		}
		return total;
	}
	
	
}
