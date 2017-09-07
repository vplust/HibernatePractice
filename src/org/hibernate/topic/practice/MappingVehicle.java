package org.hibernate.topic.practice;

import javax.persistence.*;

@Entity
public class MappingVehicle {
	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	private MappingUser user;

	public MappingUser getUser() {
		return user;
	}

	public void setUser(MappingUser user) {
		this.user = user;
	}


}
