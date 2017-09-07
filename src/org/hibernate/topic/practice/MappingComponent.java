package org.hibernate.topic.practice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MappingComponent {
	public static void main(String...strings)
	{
		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		MappingUser user =new MappingUser();
		List<MappingVehicle> vehicles = new ArrayList<>();
		user.setName("Arvind");
		user.setVehicles(vehicles);
		for(int i=0;i<10;++i){
			MappingVehicle vehicle = new MappingVehicle();
			vehicle.setUser(user);
			vehicles.add(vehicle);
		}
		session.beginTransaction();
		session.persist(user);
		
		session.getTransaction().commit();
		
	}

}
