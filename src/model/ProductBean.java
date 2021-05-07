package model;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int idProduct;
	String name;
	String type;
	String description;
	double price;
	String size;
	int iva;
	double weight;
	String age;
	int numberCopies;
	int quantity;
	String urlImage;
	

	public ProductBean() {
		idProduct = -1;
		name = "";
		type = "";
		description = "";
		price = 0;
		size ="";
		iva = 22;
		weight = 0;
		age = "";
		numberCopies =0;
		quantity=1;
		urlImage="";
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getId() {
		return idProduct;
	}

	public void setId(int id) {
		this.idProduct = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age= age;
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getNumCopies() {
		return numberCopies;
	}

	public void setNumCopies(int numberCopies) {
		this.numberCopies = numberCopies;
	}
	
	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}
	
	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}
	public void setQuantity(int a) {
		this.quantity=a;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	@Override
	public String toString() {
		return "[ " + name + "," + type +  "," +  idProduct + "," +  price + "," + iva + "," + description + "," + size + ","
				 + numberCopies + "," + weight + "," + age + " ]";
		
	}

}