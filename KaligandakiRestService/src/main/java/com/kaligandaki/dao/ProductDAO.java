package com.kaligandaki.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kaligandaki.dto.Product;

@Repository
public class ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> getProductList(){
		Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from Product");
		 
		 List<Product> prodList = query.getResultList();
		 return prodList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
