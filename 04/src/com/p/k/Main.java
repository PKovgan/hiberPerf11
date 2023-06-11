package com.p.k;

import java.util.Set;

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
			
//		Manager manager = new Manager("1234567", "Alex", 10000);
//		Employee emp1 = new Employee("asdfg", "Andrew", manager);
//		Employee emp2 = new Employee("qwert", "Albert", manager);
//		Employee emp3 = new Employee("zxcvb", "Arcadiy", manager);
//		manager.getEmployees().add(emp1);
//		manager.getEmployees().add(emp2);
//		manager.getEmployees().add(emp3);
		
		Set <Employee> employees = null;
		
		try {
			
			session.beginTransaction();
			
//			session.persist(manager);
			Manager manager = session.get(Manager.class, 1L);
//			employees = manager.getEmployees();
//			int size = employees.size();

			session.getTransaction().commit();
			
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
		

	}

}
