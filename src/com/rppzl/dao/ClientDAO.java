package com.rppzl.dao;

import com.rppzl.db.SessionFactorySingleton;
import com.rppzl.entity.Client;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDAO implements DAO<Client> {

	private final SessionFactory factory = SessionFactorySingleton.getInstance();

	@Override
	public List<Client> getList() {
		List<Client> list = null;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query<Client> query =
					session.createQuery("from Client c inner join fetch c.citizenship " +
							"left join fetch c.cityOfRegistration " +
							"left join fetch c.cityOfResidence " +
							"order by c.lastName", Client.class);
			list = query.getResultList();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(Client object) throws JDBCException {
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
	public Client get(int id) {
		Session session = factory.getCurrentSession();
		Client client = null;
		try {
			session.beginTransaction();
			client = session.get(Client.class, id);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return client;
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("delete from Client where id=:clientId");
			query.setParameter("clientId", id);
			query.executeUpdate();

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
