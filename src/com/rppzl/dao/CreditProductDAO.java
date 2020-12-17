package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.CreditProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CreditProductDAO implements DAO<CreditProduct> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<CreditProduct> getList() {
		Session session = factory.getCurrentSession();
		List<CreditProduct> list = null;
		try {
			session.beginTransaction();

			Query<CreditProduct> query = session.createQuery("from CreditProduct", CreditProduct.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(CreditProduct object) {
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
	public CreditProduct get(int id) {
		Session session = factory.getCurrentSession();
		CreditProduct creditProduct = null;
		try {
			session.beginTransaction();

			creditProduct = session.get(CreditProduct.class, id);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return creditProduct;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from CreditProduct where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
