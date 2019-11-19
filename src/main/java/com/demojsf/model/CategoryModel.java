package com.demojsf.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demojsf.entity.Category;
import com.demojsf.entity.HibernateUtil;

public class CategoryModel {

	@SuppressWarnings({ "unchecked" })
	public List<Category> findAll() {
		List<Category> categorys = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
			/* categorys = session.createQuery("from Category").list(); */
			categorys = (List<Category>)session.createCriteria(Category.class).list();
			
			transaction.commit();
		} catch (Exception e) {
			categorys = null;
			e.getSuppressed();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categorys;
	}

}