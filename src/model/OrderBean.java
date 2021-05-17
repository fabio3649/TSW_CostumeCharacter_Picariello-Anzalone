package model;

import java.io.Serializable;
import java.sql.Date;

public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int idOrder;
	String paymentMethod;
	Date date;
	String status;
	Double totalPrice;
	Double shippingCosts;
	String user;
	int address;
	


	public OrderBean() {
		
		idOrder=0;
		paymentMethod="";
		date=null;
		status="";
		totalPrice=0.0;
		shippingCosts=0.0;
		user="";
		address=0;
		
	}


	public int getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Double getShippingCosts() {
		return shippingCosts;
	}


	public void setShippingCosts(Double shippingCosts) {
		this.shippingCosts = shippingCosts;
	}
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}
	
	public int getAddress() {
		return address;
	}


	public void setAddress(int address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OrderBean [idOrder=" + idOrder + ", paymentMethod=" + paymentMethod + ", date=" + date + ", status="
				+ status + ", totalPrice=" + totalPrice + ", shippingCosts=" + shippingCosts + ", username=" + user
				+ ", address=" + address + "]";
	}


	
	
}
