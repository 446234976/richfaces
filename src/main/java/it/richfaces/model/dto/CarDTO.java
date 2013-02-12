package it.richfaces.model.dto;

public class CarDTO {
	
	private String vendor;
	private String model;
	private int price;
	private float mileage;
	private String vin;
	private String stock;
	private int daysLive;
	
	public CarDTO(){}
	
	public CarDTO(String vendor,String model,int price,float mileage,String vin,
				  String stock,int daysLive){
	this.vendor = vendor;
	this.model = model;
	this.price = price;
	this.mileage = mileage;
	this.vin = vin;
	this.stock = stock;
	this.daysLive = daysLive;
		
	}
	
	@Override
	public String toString() {
		return "CarDTO [vendor=" + vendor + ", model=" + model + ", price="
				+ price + ", mileage=" + mileage + ", vin=" + vin + ", stock="
				+ stock + ", daysLive=" + daysLive + "]";
	}

	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getMileage() {
		return mileage;
	}
	public void setMileage(float mileage) {
		this.mileage = mileage;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public int getDaysLive() {
		return daysLive;
	}
	public void setDaysLive(int daysLive) {
		this.daysLive = daysLive;
	} 
	

}
