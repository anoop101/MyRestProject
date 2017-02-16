package com.kaligandaki.junk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kaligandaki.dao.ProductDAO;
import com.kaligandaki.dto.Product;
import com.kaligandaki.rest.RootConfig;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
		/*CustomerDAO dao = ctx.getBean(CustomerDAO.class);

		System.out.println(dao.getCustomer());*/

		ProductDAO dao = ctx.getBean(ProductDAO.class);

		for(Product prod : dao.getProductList()){
			System.out.println(prod.getProductId() + " " + prod.getProductName()+ " " + prod.getMfdCompany().getCompanyId());
		}
	}

}
