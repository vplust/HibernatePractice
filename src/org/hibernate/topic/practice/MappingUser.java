package org.hibernate.topic.practice;

import java.util.List;

import javax.persistence.*;

@Entity
// NamedQuery used in org.hibernate.topic.HQL.HqlNamedQuery class
@NamedQueries({
	@NamedQuery(name="getAllObjects",query="from MappingUser")

})
public class MappingUser {
	@Id
	@GeneratedValue
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;

	/*  OneTOMany Mapping in hibernate
	 * mappedBy is used to avoid using extra table for mapping ID's of objects
	 * cascade is used for automatic saving of multiple objects by saving one object,
	  							session.persist() is used instead of session.save( )
	 */
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<MappingVehicle> vehicles; 


	/*
	@OneToOne
	private MappingVehicle vehicle;



	public MappingVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(MappingVehicle vehicle) {
		this.vehicle = vehicle;
	}
	 */
	public List<MappingVehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<MappingVehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
