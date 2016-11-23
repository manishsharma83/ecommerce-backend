package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.ProductCategory;

@Service
public interface ProductCategoryService {
	public int addProductCategory(ProductCategory productCategory);
	public ProductCategory getProductCategory(int productCategoryId);
	public void updateProductCategory(ProductCategory productCategory);
	public boolean deleteProductCategory(int productCategoryId);
	public List<ProductCategory> getAllProductCategories();
}
