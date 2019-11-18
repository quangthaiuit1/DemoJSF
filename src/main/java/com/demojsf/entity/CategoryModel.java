package com.demojsf.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CategoryModel {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Category> findAll() {
		List<Category> categorys = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from category");
			categorys = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			categorys = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categorys;
	}

}