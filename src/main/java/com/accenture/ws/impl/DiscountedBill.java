package com.accenture.ws.impl;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;

public class DiscountedBill extends OrderBill {

	public DiscountedBill(CafeClerk clerk) {
		super(clerk);
	}

	@Override
	public double getTotalBill() {
		double total = 0;
		final double DISCOUNT = .05;
		
		for(Order orders : this.orderList) {
			if(orders.isDiscounted()) {
				double totalDiscount = (orders.getPrice() * DISCOUNT);
				total += (orders.getPrice() - totalDiscount);
			}else {
				total += orders.getPrice();
			}
		}
		
		return total;
	}
	
	
}
