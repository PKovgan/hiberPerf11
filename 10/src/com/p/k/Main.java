package com.p.k;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.p.k.entity.Employee;
import com.p.k.entity.Manager;

public class Main {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Manager.class);
		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
		
		session.beginTransaction();
		
		Manager man1 = session.find(Manager.class, 2L);
//		session.evict(man1);
		Manager man2 = session.find(Manager.class, 2L);
		Manager man3 = (Manager) session.createQuery("select manager from Manager manager where manager.id = :id").setParameter("id", 2L).getSingleResult();
		
		System.out.println(man1.equals(man2));
		System.out.println(man2.equals(man3));
		
		session.getTransaction().commit();
		
		session.close();
	}
}
