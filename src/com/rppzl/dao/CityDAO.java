package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CityDAO implements DAO<City> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<City> getList() {
		List<City> list = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query<City> query = session.createQuery("from City c" +
					" join fetch c.country co order by co.country, c.name", City.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(City object) {
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
	public City get(int id) {
		Session session = factory.getCurrentSession();
		City city = null;
		try {
			session.beginTransaction();

			city = session.get(City.class, id);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return city;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from City where id=:cityId");
			query.setParameter("cityId", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
