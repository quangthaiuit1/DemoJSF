package com.demojsf.entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory =null;

	static {
		try {
//			Configuration configuration = new Configuration();  
//			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
//			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//			sessionFactory = metaData.getSessionFactoryBuilder().build();
			
			if (sessionFactory == null) {
	            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	         
	        }
	         
//		} catch (Throwable th) {
//			throw new ExceptionInInitializerError(th);
//		}
		} catch (Exception th) {
			System.out.println("Xay ra loi");
			th.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;

	}
}