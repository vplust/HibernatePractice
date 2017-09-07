package org.hibernate.tryouts;

import org.hibernate.*;
import org.hibernate.cfg.*;
public class FirstHibernate {

	public static void main(String[] args) {
		
		//FirstHibernatePojo
		FirstHibernatePojo student = new FirstHibernatePojo();
		
		student.setName("sunny");
		
	
		/*
		//UserDetails Vehicle One to many
		UserDetails user = new UserDetails();
		Vehicle vehicle = null;
		for(int i=0; i<10;++i)
		{
			vehicle = new Vehicle();
			user.getVehicle().add(vehicle);
			vehicle.setUser(user);
		}
		*/
		
		//reads configuration file to create session factory
		Configuration con = new Configuration().configure();
		//one session factory object for whole application
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		//work inside transaction then commit
		session.beginTransaction();
		
		session.save(student);
		/*
		session.save(user);
		session.save(vehicle);
		*/
		//session.get(FirstHibernatePojo.class, 1);
		session.getTransaction().commit();
		session.close();
		
		/* session = sf.openSession();
		 FirstHibernatePojo pj = (FirstHibernatePojo) session.get(FirstHibernatePojo.class, 1);
		 System.out.println(pj.getName());*/
	}

}
