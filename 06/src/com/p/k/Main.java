package com.p.k;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

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
		
//		Manager man1 = new Manager("qwerty", "Arnold Shwarzenegger", 10000);
//		Manager man2 = new Manager("asdfgh", "Silvester Stallone", 15000);
//		Manager man3 = new Manager("zxcvbnm", "Dolph Lungren", 20000);
//		Employee emp1 = new Employee("1234", "Vasyl", man1);
//		man1.getEmployees().add(emp1);
//		Employee emp2= new Employee("2345", "Andrew", man2);
//		man2.getEmployees().add(emp2);
//		Employee emp3 = new Employee("3456", "Petro", man2);
//		man2.getEmployees().add(emp3);
//		Employee emp4 = new Employee("4567", "Vlad", man3);
//		man3.getEmployees().add(emp4);
//		Employee emp5 = new Employee("5678", "Sergiy", man3);
//		man3.getEmployees().add(emp5);
			
		try {
			session.beginTransaction();
//			session.persist(man1);
//			session.persist(man2);
//			session.persist(man3);
			
//			Query query = session.createQuery("select employee from Employee employee");
			Query query = session.createQuery("select employee from Employee employee left join fetch employee.manager");
			
			List<Employee> emps = query.getResultList();
			emps.stream().forEach(b -> System.out.println(b.toString()));
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
		
	}
}
