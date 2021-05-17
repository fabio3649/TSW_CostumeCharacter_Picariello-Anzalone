package model;

import java.io.Serializable;

public class ImageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String url;
	int product;
	boolean main;
	
	
	public ImageBean() {
		
		url="";
		product=0;
		main=true;
		
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getProduct() {
		return product;
	}


	public void setProduct(int product) {
		this.product = product;
	}


	public boolean isMain() {
		return main;
	}


	public void setMain(boolean main) {
		this.main = main;
	}
	
	

}
