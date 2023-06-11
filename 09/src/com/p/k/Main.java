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
		
		Manager man = null;
		Employee emp = null;
			
		session.beginTransaction();
			man = session.find(Manager.class, 2L);
			Set<Employee> emps = man.getEmployees();
			for(Employee employee : emps) {
				if (employee.getId() == 5L) emp = employee;
			}
			
		session.getTransaction().commit();
		
		man.setSalary(15000);
		emp.setName("Andrew");
		
		session.beginTransaction();
		session.getTransaction().commit();
		
		session.close();
	}
}
