package org.hibernate.topic.practice;

import javax.persistence.*;

@Entity
public class InheritanceBike extends InheritanceVehicle{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}