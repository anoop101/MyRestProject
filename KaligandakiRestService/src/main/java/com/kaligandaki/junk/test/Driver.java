package com.kaligandaki.junk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kaligandaki.config.RootConfig;
import com.kaligandaki.service.ProductService;
import com.kaligandaki.vo.Product;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
		/*
		 * CustomerDAO dao = ctx.getBean(CustomerDAO.class);
		 * 
		 * System.out.println(dao.getCustomer());
		 */

		ProductService prodService = ctx.getBean(ProductService.class);

		for (Product prod : prodService.getProductList(0, 0)) {
			System.out.println("\nProductId - " + prod.getProductId() + "\nProductName - " + prod.getProductName()
					+ "\nPrice - " + prod.getPrice() + "\nCategory - " + prod.getProductCategory());
		}
	}

}
