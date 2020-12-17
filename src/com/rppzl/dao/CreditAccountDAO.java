package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.CreditAccount;
import com.rppzl.entity.DepositAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CreditAccountDAO implements DAO<CreditAccount> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<CreditAccount> getList() {
		List<CreditAccount> list = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query<CreditAccount> query = session.createQuery("from CreditAccount d" +
					" join fetch d.personalAccount" +
					" join fetch d.product", CreditAccount.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(CreditAccount object) {
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
	public CreditAccount get(int id) {
		Session session = factory.getCurrentSession();
		CreditAccount creditAccount = null;
		try {
			session.beginTransaction();

			creditAccount = session.get(CreditAccount.class, id);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return creditAccount;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from CreditAccount where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
