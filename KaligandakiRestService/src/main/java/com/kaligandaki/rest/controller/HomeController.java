package com.kaligandaki.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kaligandaki.vo.Product;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}


	@RequestMapping(value = "/getNewProduct", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getNewProduct() {
		Product prod = new Product();
		prod.setProductId(2);
		prod.setProductName("Prakash Telephone Cables");
		prod.setProductCategory("Wires");
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
}
