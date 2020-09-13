package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CountryDAO implements DAO<Country> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<Country> getList() {
		Session session = factory.getCurrentSession();
		List<Country> list = null;
		try {
			session.beginTransaction();

			Query<Country> query = session.createQuery("from Country c order by c.country", Country.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(Country object) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			session.saveOrUpdate(object);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public Country get(int id) {
		Session session = factory.getCurrentSession();
		Country country = null;
		try {
			session.beginTransaction();

			country = session.get(Country.class, id);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return country;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from Country where id=:countryId");
			query.setParameter("countryId", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
