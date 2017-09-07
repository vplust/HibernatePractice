package org.hibernate.topic.practice.HQL;
import org.hibernate.topic.practice.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

// Basic Query 
		 /* 
		  * use Classname in from clause
		 */
		Query query = session.createQuery("from MappingUser");
		List<MappingUser> users = query.list();

		/*Pagination
		 */
		query.setFirstResult(2);
		query.setMaxResults(4);

//Advance Query
		/*
		 * To get one particular fields from database
		 */
		Query advQuery = session.createQuery("select name from MappingUser");
		List<String> names = advQuery.list();
		
		/*
		 * To get any desired number of field from database as List of Lists
		*/
		advQuery = session.createQuery("select new List(id,name) from MappingUser");
		List<List> namesIdMap = advQuery.list();

		/*Prepared Query
		 * :queryvariable like names are used in query to provide value of variable in query at later point of time
		 * prepared queries are used for Insert queries
		
		Query preparedQuery = session.createQuery("Insert into MappingUser(id,name) values(:id,':name') ");
		preparedQuery.setInteger("id",10);
		preparedQuery.setString("fieldName", "name");
		int pq = preparedQuery.executeUpdate();
		*/
		session.getTransaction().commit();
		System.out.println(users.size());
		System.out.println(names.size());
		System.out.println(namesIdMap.size());
		
		/*
		for(String s: names)
			System.out.println(s);
		 */

		for(List l : namesIdMap)
		{
			System.out.println(l);
		}


	}

}
