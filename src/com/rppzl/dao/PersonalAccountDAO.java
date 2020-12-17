package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.City;
import com.rppzl.entity.PersonalAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PersonalAccountDAO implements DAO<PersonalAccount> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<PersonalAccount> getList() {
		List<PersonalAccount> list = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query<PersonalAccount> query = session.createQuery("from PersonalAccount p" +
					" join fetch p.client", PersonalAccount.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(PersonalAccount object) {
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
	public PersonalAccount get(int id) {
		Session session = factory.getCurrentSession();
		PersonalAccount personalAccount = null;
		try {
			session.beginTransaction();

			personalAccount = session.get(PersonalAccount.class, id);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return personalAccount;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from PersonalAccount where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
