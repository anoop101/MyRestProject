
package com.kaligandaki.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kaligandaki.dao.ProductDAO;
import com.kaligandaki.dto.ProductDTO;
import com.kaligandaki.vo.Product;

@Transactional
public class ProductService {

	private ProductDAO productDAO;

	@Transactional
	public List<Product> getProductList(int start, int count) {
		return getProductListVO(productDAO.getProductList(start, count));
	}

	private List<Product> getProductListVO(List<ProductDTO> productList) {
		List<Product> productVOList = new ArrayList<>();
		for (ProductDTO prodDTO : productList) {
			Product prod = new Product();
			prod.setProductId(prodDTO.getProductId());
			prod.setProductName(prodDTO.getProductName());
			prod.setPrice(prodDTO.getPrice());
			prod.setProductCategory(prodDTO.getCategory().getProductCategory());
			productVOList.add(prod);
		}
		return productVOList;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

}
