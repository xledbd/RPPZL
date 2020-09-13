package com.rppzl.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {
	private static SessionFactory instance = null;

	private SessionFactorySingleton() {

	}

	public static SessionFactory getInstance() {
		if (instance == null)
			instance = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return instance;
	}
}
