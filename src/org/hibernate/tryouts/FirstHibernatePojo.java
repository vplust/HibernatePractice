package org.hibernate.tryouts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	//(name="students") // changes Entity name does not change name of table in DB
@Table(name="Student") // change name of Table in DB (PREFER THIS)
public class FirstHibernatePojo {
	@Id
	@GeneratedValue
	@Column(name="rno")
	private int rollnumber;
	private String name ;
	
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
