package com.ashijaingarg.prac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ashijaingarg.prac.dao.CategoryDAOImpl;
import com.ashijaingarg.prac.dao.SubCategoryDAOImpl;
import com.ashijaingarg.prac.model.Category;
import com.ashijaingarg.prac.model.SubCategory;

@Service
public class SubCategoryService {
	
	private CategoryDAOImpl categoryDaoImpl;
	private SubCategoryDAOImpl subCategoryDaoImpl;
	
	public void setCategoryDaoImpl(CategoryDAOImpl categoryDaoImpl) {
		this.categoryDaoImpl = categoryDaoImpl;
	}

	public void setSubCategoryDaoImpl(SubCategoryDAOImpl subCategoryDaoImpl) {
		this.subCategoryDaoImpl = subCategoryDaoImpl;
	}
	
	@Transactional
	public List<Category> getAllCategories() {
		return this.categoryDaoImpl.getAllCategories();
	}
	
	@Transactional
	public void addSubCategory(SubCategory subCategory) {
		this.subCategoryDaoImpl.addSubCategory(subCategory);
	}
	
	@Transactional
	public List<SubCategory> getAllSubCategories() {
		return this.subCategoryDaoImpl.getAllSubCategories();
	}
	
	@Transactional
	public Category getCategoryById(int id) {
		return this.subCategoryDaoImpl.getCategoryById(id);
	}

}
