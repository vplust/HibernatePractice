package org.hibernate.tryouts;

import java.util.*;

import javax.persistence.*;

@Entity
public class UserDetails {
	@Id @GeneratedValue
	private int userid;
	@OneToMany(mappedBy="user")
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
}
