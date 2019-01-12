package com.ashijaingarg.prac.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ashijaingarg.prac.controller.SubCategoryController;
import com.ashijaingarg.prac.dao.ProductDAOImpl;
import com.ashijaingarg.prac.dao.SubCategoryDAOImpl;
import com.ashijaingarg.prac.model.Product;
import com.ashijaingarg.prac.model.SubCategory;

@Service
public class ProductService {
	
	Logger log = Logger.getLogger(ProductService.class.getName());
	
	private ProductDAOImpl productDaoImpl;
	private SubCategoryDAOImpl subCategoryDaoImpl;
	
	public SubCategoryDAOImpl getSubCategoryDaoImpl() {
		return subCategoryDaoImpl;
	}

	public void setSubCategoryDaoImpl(SubCategoryDAOImpl subCategoryDaoImpl) {
		this.subCategoryDaoImpl = subCategoryDaoImpl;
	}

	public ProductDAOImpl getProductDaoImpl() {
		return productDaoImpl;
	}

	public void setProductDaoImpl(ProductDAOImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	@Transactional
	public void addProduct(Product product) {
		this.productDaoImpl.addProduct(product);
	}
	
	@Transactional
	public List<Product> getProducts() {
		return this.productDaoImpl.getAllProducts();
	}
	
	
	@Transactional
	public List<Product> getProductsForSubCategory(int subCategoryId) {
		SubCategory subCategory = productDaoImpl.getSubCategoryById(subCategoryId);
		return new ArrayList<Product>(subCategory.getProducts());
	}
	
	@Transactional
	public List<SubCategory> getAllSubCategories() {
		return this.subCategoryDaoImpl.getAllSubCategories();
	}
	
	@Transactional
	public SubCategory getSubCategoryById(int id) {
		SubCategory subCategory = productDaoImpl.getSubCategoryById(id);
		log.info("Before product fetch");
		subCategory.getProducts();
		return subCategory;
	}
	
	

}
