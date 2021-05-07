package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<ProductBean> products;
	
	public Cart() {
		products = new ArrayList<ProductBean>();
	}

	public void addProduct(ProductBean product) {
		if(this.isContain(product)) {
			int pos = this.getProductPosition(product);
			ProductBean bean = this.getProduct(product.getId());
			this.deleteProduct(bean);
			bean.setQuantity(bean.getQuantity()+1);
			products.add(pos, bean);
		}
		else {
			
			products.add(product);
		}
	}
	
	public void deleteProduct(ProductBean product) {
		for(ProductBean prod : products) {
			if(prod.getId() == product.getId()) {
				products.remove(prod);
				break;
			}
		}
 	}
	
	public boolean isContain(ProductBean bean) {
		
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId()==bean.getId()) 
				return true;
		}
		return false;
	}
	
	public int getProductPosition(ProductBean bean) {
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId()==bean.getId())
				return i;
		}
		return -1;
		
	}
	
	
	public ProductBean getProduct(int id) {
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId()==id)
				return products.get(i);
		}
		return null;
	}
	
	public boolean productContain(int id) {
		for(int i=0;i<this.products.size();i++) {
			if(products.get(i).getId()==id)
				return true;
		}
		return false;
	}
	
	public List<ProductBean> getProducts() {
		return  products;
	}
}

