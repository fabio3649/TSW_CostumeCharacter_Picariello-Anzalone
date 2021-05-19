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
			ProductBean bean = this.getProduct(product.getId());
			bean.setQuantity(bean.getQuantity()+1);
		}
		else {
			products.add(product);
		}
	}
	
	public void deleteProduct(ProductBean product) {
		ProductBean bean = this.getProduct(product.getId());
				if(bean.getQuantity()<2) {
					products.remove(bean);
				}
				else {
					bean.setQuantity(bean.getQuantity()-1);
				}
 	}
	
	public boolean isContain(ProductBean bean) {
		
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId()==bean.getId()) 
				return true;
		}
		return false;
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

