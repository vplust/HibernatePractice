package org.hibernate.topic.practice;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class InheritanceComponent {
	public static void main(String...strings)
	{
		InheritanceBike bike = new InheritanceBike();
		bike.setOwnerName("Arvind");
		bike.setName("Passion");
		InheritanceVehicle vehicle = new InheritanceVehicle();
		vehicle.setOwnerName("Arvind");
		InheritanceCar car = new InheritanceCar();
		car.setOwnerName("Arvind");
		car.setName("Alto k10");
		
		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bike);
		session.save(car);
		session.save(vehicle);
		session.getTransaction().commit();
		
	}

}
