package com.p.k;

import java.util.HashSet;
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
			
//		Set <Employee> employees = new HashSet<Employee>();
//		Employee emp1 = new Employee("123456", "ALbert Einstein");
//		Employee emp2 = new Employee("123456", "ALbert Einstein");
//		
//		employees.add(emp1);
//		employees.add(emp2);
//		
//		employees.stream().forEach(b -> System.out.println(b.toString()));
//		
//		System.out.println("1 equals 2: " + emp1.equals(emp2));
//		System.out.println("Set contains 1: " + employees.contains(emp1));
//		System.out.println("Set contains 2: " + employees.contains(emp2));
		
//		Manager manager = new Manager("asdfg", "Alfred Hichckok", 10000);
//		Employee emp1 = new Employee("123456", "ALbert Einstein", manager);
//		Employee emp2 = new Employee("234567", "Andron Collaider", manager);
//		manager.getEmployees().add(emp1);
//		manager.getEmployees().add(emp2);
		
		Set<Employee> employees = null;
		Employee emp1 = null;
		
		try {
			session.beginTransaction();
			emp1 = session.find(Employee.class, 2L);
			Manager manager = session.find(Manager.class, 1L);
			employees = manager.getEmployees();
			System.out.println("Set contains 2L: " + employees.contains(emp1));
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
		
		session = configuration.buildSessionFactory(serviceRegistry).openSession();
		try {
			session.beginTransaction();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
	}
}
