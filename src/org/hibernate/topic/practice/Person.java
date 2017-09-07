
package org.hibernate.topic.practice;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import javax.persistence.*;
/*
 * All data types use Example
 */
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
//Multiple Embedded objects of same class, Override Attributes name 
	@AttributeOverrides({
		@AttributeOverride(name="Flat_Street_Neighbourhood", column=@Column(name="homeFlat")),
		@AttributeOverride(name="city", column=@Column(name="homeCity")),
		@AttributeOverride(name="state", column=@Column(name="homeState")),
		@AttributeOverride(name="country", column=@Column(name="homeCountry")),
		@AttributeOverride(name="pincode", column=@Column(name="homePincode"))		
	})
	private AddressEmbeddableInPerson addressHome;
	@AttributeOverrides({
		@AttributeOverride(name="Flat_Street_Neighbourhood", column=@Column(name="officeFlat")),
		@AttributeOverride(name="city", column=@Column(name="officeCity")),
		@AttributeOverride(name="state", column=@Column(name="officeState")),
		@AttributeOverride(name="country", column=@Column(name="officeCountry")),
		@AttributeOverride(name="pincode", column=@Column(name="officePincode"))		
	})
	private AddressEmbeddableInPerson addressOffice;
	
	@Lob
	private byte[] picture;

//Temporal should only be placed of java.util.Date
	@Temporal(TemporalType.DATE)  
	private Date dob;
//@Transient
	private Timestamp attendanceTime;
	
//Saving Collection
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> placesVisited;
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Timestamp getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(Timestamp attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public AddressEmbeddableInPerson getAddressHome() {
		return addressHome;
	}
	public void setAddressHome(AddressEmbeddableInPerson addressHome) {
		this.addressHome = addressHome;
	}
	public AddressEmbeddableInPerson getAddressOffice() {
		return addressOffice;
	}
	public void setAddressOffice(AddressEmbeddableInPerson addressOffice) {
		this.addressOffice = addressOffice;
	}
	public List<String> getPlacesVisited() {
		return placesVisited;
	}
	public void setPlacesVisited(List<String> placesVisited) {
		this.placesVisited = placesVisited;
	}
	
	
	

}
