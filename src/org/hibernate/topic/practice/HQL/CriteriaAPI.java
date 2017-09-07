package org.hibernate.topic.practice.HQL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.topic.practice.MappingUser;

public class CriteriaAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(MappingUser.class);
		criteria.add(Restrictions.gt("id", 0));
		
		List users= criteria.list();
		session.getTransaction().commit(); 
		System.out.println(users.size());

	}

}
