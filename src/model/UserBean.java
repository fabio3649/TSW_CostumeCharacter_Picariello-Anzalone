package model;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String username;
	String password;
	String name;
	String surname;
	int telephoneNumber;
	String email;
	String billingAddress;
	int billingCAP;
	String billingCity;
	String billingProvince;
	
	public UserBean()
	{
		username="";
		password="";
		name="";
		surname="";
		telephoneNumber=0;
		email="";
		billingAddress="";
		billingCAP=0;
		billingCity="";
		billingProvince="";
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public int getBillingCAP() {
		return billingCAP;
	}

	public void setBillingCAP(int billingCAP) {
		this.billingCAP = billingCAP;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingProvince() {
		return billingProvince;
	}

	public void setBillingProvince(String billingProvince) {
		this.billingProvince = billingProvince;
	}

	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", telephoneNumber=" + telephoneNumber + ", email=" + email + ", billingAddress=" + billingAddress
				+ ", billingCAP=" + billingCAP + ", billingCity=" + billingCity + ", billingProvince=" + billingProvince
				+ "]";
	}

	
	
}
