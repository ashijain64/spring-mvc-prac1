package com.ashijaingarg.prac.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashijaingarg.prac.model.Product;
import com.ashijaingarg.prac.model.SubCategory;
import com.ashijaingarg.prac.service.ProductService;

@Controller
public class ProductController {
	
	Logger log = Logger.getLogger(ProductController.class.getName());
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String showProduct(ModelMap model) {	
		List<SubCategory> subCategories = productService.getAllSubCategories();
		model.put("subCategories", subCategories);
		Product product = new Product();
		model.put("product", product);
		return "product";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(Product product, BindingResult result, ModelMap model) {
		System.out.println("------------" + product.getSubCategoryId());
		SubCategory subCategory = productService.getSubCategoryById(Integer.parseInt(product.getSubCategoryId()));
		product.setSubCategory(subCategory);
	    productService.addProduct(product);
		model.put("product",new Product());
		return "product";
	}
	
	@RequestMapping(value = "/product/{id}",  method = RequestMethod.GET)
	public String showProductDetails( @PathVariable("id") int id, ModelMap model) {
		log.info("Product id in request : " + id);
		Product productById = productService.getProductById(id);
		log.info("Product from db : " + productById);
		model.put("product", productById);
		return "product-home";
		
	}
	

}
