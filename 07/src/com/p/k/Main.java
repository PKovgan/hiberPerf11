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
//		Manager man4 = new Manager("werty", "Stiven Spilberg", 20500);
//		Manager man5 = new Manager("sdfgh", "Kevin Costner", 21000);
//		Manager man6 = new Manager("xcvbn", "Jerar Depardue", 22000);
//		Manager man7 = new Manager("dfghj", "Tom Cruze", 22500);
//		Manager man8 = new Manager("cvbnm", "Meecky Rourke", 23000);
//		Manager man9 = new Manager("rtyui", "Chuck Norris", 23500);
//		Manager man10 = new Manager("fghjk", "Bruce Lee", 24000);
//		
//		Employee emp1 = new Employee("1234", "Vasyl", man1);
//		man1.getEmployees().add(emp1);
//		Employee emp2 = new Employee("2345", "Andrew", man2);
//		man2.getEmployees().add(emp2);
//		Employee emp3 = new Employee("3456", "Petro", man3);
//		man3.getEmployees().add(emp3);
//		Employee emp4 = new Employee("4567", "Vlad", man4);
//		man4.getEmployees().add(emp4);
//		Employee emp5 = new Employee("5678", "Sergiy", man5);
//		man5.getEmployees().add(emp5);
//		Employee emp6 = new Employee("6789", "Anton", man6);
//		man6.getEmployees().add(emp6);
//		Employee emp7 = new Employee("7890", "Boris", man7);
//		man7.getEmployees().add(emp7);
//		Employee emp8 = new Employee("1111", "Valeriy", man8);
//		man8.getEmployees().add(emp8);
//		Employee emp9 = new Employee("2222", "Ivan", man9);
//		man9.getEmployees().add(emp9);
//		Employee emp10 = new Employee("3333", "Chuck", man10);
//		man10.getEmployees().add(emp10);
			
		try {
			session.beginTransaction();
//			session.persist(man1);
//			session.persist(man2);
//			session.persist(man3);
//			session.persist(man4);
//			session.persist(man5);
//			session.persist(man6);
//			session.persist(man7);
//			session.persist(man8);
//			session.persist(man9);
//			session.persist(man10);
			
			Query query = session.createQuery("select employee from Employee employee");
			
			List<Employee> emps = query.getResultList();
			emps.stream().forEach(b -> System.out.println(b.toString()));
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
		
	}
}
