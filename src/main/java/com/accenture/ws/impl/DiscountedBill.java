package com.accenture.ws.impl;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;

public class DiscountedBill extends OrderBill {

	public DiscountedBill(CafeClerk clerk) {
		super(clerk);
	}

	public double getTotalBill() {
		double total = 0;
		final double DISCOUNT = .05;
		
		for(Order orders : this.orderList) {
			if(orders.isDiscounted()) {
				total += (orders.getPrice() * DISCOUNT);
			}else {
				total += orders.getPrice();
			}
		}
		
		return total;
	}
	
	
}
