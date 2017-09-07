package org.hibernate.topic.practice;

import javax.persistence.Embeddable;

@Embeddable
public class AddressEmbeddableInPerson {
	private String Flat_Street_Neighbourhood;
	private String city;
	private String state;
	private String country;
	int pincode;
	public String getFlat_Street_Neighbourhood() {
		return Flat_Street_Neighbourhood;
	}
	public void setFlat_Street_Neighbourhood(String flat_Street_Neighbourhood) {
		Flat_Street_Neighbourhood = flat_Street_Neighbourhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
