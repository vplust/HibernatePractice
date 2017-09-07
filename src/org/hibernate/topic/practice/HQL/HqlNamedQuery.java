package org.hibernate.topic.practice.HQL;

import org.hibernate.topic.practice.*;
import java.util.List;
import javax.persistence.*;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
/* NamedQuery
 * NamedQueries are placed in Entity class, like this one has named query in MappingUser class
@NamedQueries({
	@NamedQuery(name="getAllObjects",query="from MappingUser")

})
*/
public class HqlNamedQuery {
	public static void main(String... args)
	{
		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("getAllObjects");
		List users = query.list();
		session.getTransaction().commit(); 
		System.out.println(users.size());
	}

}
