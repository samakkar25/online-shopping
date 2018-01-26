package com.app.fantastic.Aweb.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.fantastic.Aweb.dao.CategoryDAO;
import com.app.fantastic.Aweb.dto.Category;


@Repository("dao")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionfactory; 
	
	@Override
	public List<Category> list() {
		String selectActiveCategory = "from Category where active = :active"; 
		Query query = sessionfactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
		
	}
	
	/*
	 * Getting Single catgry based on id
	*/
	@Override
	public Category get(int id) {
		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	
	@Override
	public boolean add(Category category) {
		try {
			sessionfactory.getCurrentSession().persist(category);
			return true;
		} catch(Exception e) {
			System.out.println("DAO IMP exception occured");
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean update(Category category) {
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch(Exception e) {
			System.out.println("DAO IMP exception occured");
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch(Exception e) {
			System.out.println("DAO IMP exception occured");
			e.printStackTrace();
			return false;
		}
	}
	
}