package com.as.rest.agent.dao;

import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static Configuration configuration;

	// Create the initial SessionFactory from the default configuration files
	static {
		try {
			configuration = new Configuration();
			sessionFactory = configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println(ex);
			throw new ExceptionInInitializerError(ex);			
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
