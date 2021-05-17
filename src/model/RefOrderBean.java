package model;

import java.io.Serializable;

public class RefOrderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int order;
	int product;
	int quantity;
	Double sellingPrice;
	int iva;
	
	public RefOrderBean()
	{
		order=0;
		product=0;
		quantity=0;
		sellingPrice=0.0;
		iva=0;
		
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "RefOrderBean [order=" + order + ", product=" + product + ", quantity=" + quantity + ", sellingPrice="
				+ sellingPrice + ", iva=" + iva + "]";
	}

	
	
	

	
	
	

}
