package org.hibernate.topic.practice;

import java.io.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class PersonService{
	private static Configuration con = new Configuration().configure() ;
	private static SessionFactory sessionFactory = con.buildSessionFactory();
	
	public static void save(Person person){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
	}
	
	public static void get(int id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person person=(Person)session.get(Person.class, id);
		session.getTransaction().commit();
		System.out.println(person.getName());
		System.out.println(person.getAddressHome().getFlat_Street_Neighbourhood());
		System.out.println(person.getPlacesVisited().size());
	}
	
	

}
