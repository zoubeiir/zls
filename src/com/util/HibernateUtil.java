package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static final SessionFactory sessionFactory;

	static {
		try {
			
//			BasicConfigurator.configure();
			// Cr�ation de la SessionFactory � partir de hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal session = new ThreadLocal();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
