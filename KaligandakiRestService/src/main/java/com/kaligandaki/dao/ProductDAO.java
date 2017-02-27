package com.kaligandaki.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.cache.annotation.Cacheable;

import com.kaligandaki.dto.ProductDTO;

public class ProductDAO {

	private SessionFactory sessionFactory;

	@Cacheable(value="productsCache")
	public List<ProductDTO> getProductList(int start, int count) {
		List<ProductDTO> prodList = new ArrayList<>();
		try {
			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from ProductDTO");
			if(start != 0)
				query.setFirstResult(start);
			if(count != 0)	
				query.setMaxResults(count);
			
			prodList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prodList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
