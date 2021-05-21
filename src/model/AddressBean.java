package model;

import java.io.Serializable;

public class AddressBean implements Serializable {

	private static final long serialVersionUID = 1L;

	int idAddress;
	String city;
	String address;
	int cap;
	String province;
	String user;
	boolean visible;
	
	
	public AddressBean () {
		
		idAddress=0;
		city="";
		address="";
		cap=0;
		province="";
		user="";
		visible=true;
		
		
	}


	public int getIdAddress() {
		return idAddress;
	}


	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getCap() {
		return cap;
	}


	public void setCap(int cap) {
		this.cap = cap;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	@Override
	public String toString() {
		return "AddressBean [idAddress=" + idAddress + ", city=" + city + ", address=" + address + ", cap=" + cap
				+ ", province=" + province + ", user=" + user + ", visible=" + visible + "]";
	}
	
	public String toStringReduce() {
		
		return address + " " + city + " " + province + " " +  cap ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
