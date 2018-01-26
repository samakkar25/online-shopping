package com.app.fantastic.Aweb.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.fantastic.Aweb.dao.ProductDAO;
import com.app.fantastic.Aweb.dto.Product;


@Repository("prodDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {


	@Autowired
	private SessionFactory sessionfactory; 
	
	@Override
	public boolean add(Product product) {
		try {
			sessionfactory
			.getCurrentSession()
				.persist(product);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionfactory
			.getCurrentSession()
				.update(product);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionfactory
			.getCurrentSession()
				.persist(product);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Product get(int productId) {
		return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}
	
	@Override
	public List<Product> list() {
		return sessionfactory
				.getCurrentSession()
					.createQuery("from Product", Product.class)
						.getResultList();
	}
	
	
	@Override
	public List<Product> listActiveProducts() {
		String activeProduts = "from Product where active=:active";
		return sessionfactory
			.getCurrentSession()
				.createQuery(activeProduts, Product.class)
					.setParameter("active", true)
						.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String activeProdutsByCategory = "from Product where active=:active and categoryId=:categoryId";
		return sessionfactory
			.getCurrentSession()
				.createQuery(activeProdutsByCategory, Product.class)
					.setParameter("active", true)
					.setParameter("categoryId", categoryId)
						.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String activeProdutsByCategory = "from Product where active=:active Order by id";
		return sessionfactory
			.getCurrentSession()
				.createQuery(activeProdutsByCategory, Product.class)
					.setParameter("active", true)
					.setFirstResult(0)
					.setMaxResults(count)
						.getResultList();
		
	}
	
	
}
