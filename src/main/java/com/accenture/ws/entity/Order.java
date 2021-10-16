package com.accenture.ws.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`order`")
public class Order {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String orderName;
	private double price;
	private boolean isDiscounted;
	private final double discountPercentage = 5.0;  //set this variable to constant to resolve the code smell in SonarQube
	
	/**
	 * 
	 */
	public Order() {
		//default constructor
	}

	/**
	 * @param orderName
	 * @param price
	 * @param isDiscounted
	 */
	public Order(String orderName, 
			double price, 
			boolean isDiscounted) {
		this.orderName = orderName;
		this.price = price;
		this.isDiscounted = isDiscounted;
	}

	@Column
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Column
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column
	public boolean isDiscounted() {
		return isDiscounted;
	}

	public void setIsDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}

	@Column
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	
	
	
	/*
	 * 
	 *  Override equals and hashCode methods for easy JUnit test implementation
	 * 
	 * 
	 */

	@Override
	public int hashCode() {
		return Objects.hash(discountPercentage, id, isDiscounted, orderName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		return Double.doubleToLongBits(
				discountPercentage) == Double.doubleToLongBits(
						other.discountPercentage)
				&& id == other.id 
				&& isDiscounted == other.isDiscounted 
				&& Objects.equals(orderName, other.orderName)
				&& Double.doubleToLongBits(
						price) == Double.doubleToLongBits(other.price);
	}
	
	
	
}
