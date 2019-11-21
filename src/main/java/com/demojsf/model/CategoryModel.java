package com.demojsf.model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demojsf.entity.Category;

public class CategoryModel {
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private Category category;
	
	
	public void addCategory(String name) {
		Session session = null;
		Transaction transaction = null;

	
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Date date = new Date();
			category = new Category();
			category.setName(name);
			category.setCreatedDate(date);
			session.save(category);
			transaction.commit();
	      } catch (HibernateException e) {
	         if (transaction != null) transaction.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	@SuppressWarnings({"unchecked" })
	public List<Category> findAll() {
		List<Category> categorys = null;
		Session session = null;
		Transaction transaction = null;
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			categorys = session.createQuery("from Category").list();
			transaction.commit();
			System.out.println("hết findAll");
		} catch (Exception e) {
			categorys = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categorys;
	}
	public void updateCategory(String name,int id){
		Session session = null;
		Transaction transaction = null;

	
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Category category = (Category)session.get(Category.class, id); 
			Date date = new Date();
			category.setName(name);
			category.setModifiedDate(date);

			session.update(category);
			transaction.commit();
	      } catch (HibernateException e) {
	         if (transaction != null) transaction.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }

	}
	public void deleteCategory(int id){
		Session session = null;
		Transaction transaction = null;
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			category = (Category)session.get(Category.class, id);
			session.delete(category);
			transaction.commit();
		} catch (Exception e) {
			e.getStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public Category findById(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			category = (Category)session.get(Category.class, id);
			transaction.commit();
		} catch (Exception e) {
			category = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return category;
	}
}