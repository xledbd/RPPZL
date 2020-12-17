package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.City;
import com.rppzl.entity.Country;
import com.rppzl.entity.DepositProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DepositProductDAO implements DAO<DepositProduct> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<DepositProduct> getList() {
		Session session = factory.getCurrentSession();
		List<DepositProduct> list = null;
		try {
			session.beginTransaction();

			Query<DepositProduct> query = session.createQuery("from DepositProduct", DepositProduct.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(DepositProduct object) {
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
	public DepositProduct get(int id) {
		Session session = factory.getCurrentSession();
		DepositProduct depositProduct = null;
		try {
			session.beginTransaction();

			depositProduct = session.get(DepositProduct.class, id);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return depositProduct;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from DepositProduct where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
