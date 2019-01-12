package com.ashijaingarg.prac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashijaingarg.prac.model.Product;
import com.ashijaingarg.prac.model.SubCategory;
import com.ashijaingarg.prac.service.ProductService;

@Controller
public class ProductController {
	
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
	

}
