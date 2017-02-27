package com.kaligandaki.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaligandaki.service.ProductService;
import com.kaligandaki.vo.Product;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/allProduct", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getNewProduct(@RequestParam(name = "start", defaultValue = "0") int start,
			@RequestParam(name = "count", defaultValue = "0") int count) {
		List<Product> productList = productService.getProductList(start, count);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
