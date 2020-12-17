package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.DepositAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DepositAccountDAO implements DAO<DepositAccount> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<DepositAccount> getList() {
		List<DepositAccount> list = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query<DepositAccount> query = session.createQuery("from DepositAccount d" +
					" join fetch d.personalAccount" +
					" join fetch d.product", DepositAccount.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(DepositAccount object) {
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
	public DepositAccount get(int id) {
		Session session = factory.getCurrentSession();
		DepositAccount depositAccount = null;
		try {
			session.beginTransaction();

			depositAccount = session.get(DepositAccount.class, id);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return depositAccount;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from DepositAccount where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
