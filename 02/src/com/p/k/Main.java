package com.p.k;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.p.k.entity.Blogger;
import com.p.k.entity.Facebooker;
import com.p.k.entity.Instagrammer;

public class Main {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		configuration.addAnnotatedClass(Blogger.class);
		configuration.addAnnotatedClass(Facebooker.class);
		configuration.addAnnotatedClass(Instagrammer.class);
		Session session = configuration.buildSessionFactory(serviceRegistry).openSession();
			
			Facebooker fb = new Facebooker();
			fb.setName("Alex");
			Instagrammer insta = new Instagrammer();
			insta.setName("Petro");
	
			
		try {
			
			session.beginTransaction();
			
			session.persist(fb);
			session.persist(insta);
			Query query = session.createQuery("select blogger from Blogger blogger");
			List<Blogger> bloggers = query.getResultList();
			for (Blogger bl : bloggers)  System.out.println(bl);
			query = session.createQuery("select instagrammer from Instagrammer instagrammer");
			List<Instagrammer> instagrammers = query.getResultList();
			for (Instagrammer inst : instagrammers)  System.out.println(inst); 

			session.getTransaction().commit();
			
		} catch (Exception e) {
		} finally {
			if (session != null) session.close();
		}
		

	}

}
