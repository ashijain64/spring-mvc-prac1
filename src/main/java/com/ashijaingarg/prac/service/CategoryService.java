package com.ashijaingarg.prac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ashijaingarg.prac.dao.CategoryDAOImpl;
import com.ashijaingarg.prac.model.Category;

@Service
public class CategoryService {
	
	private CategoryDAOImpl categoryDaoImpl;
	
	public void setCategoryDaoImpl(CategoryDAOImpl categoryDaoImpl) {
		this.categoryDaoImpl = categoryDaoImpl;
	}

	@Transactional
	public void addCategory(Category category) {
		this.categoryDaoImpl.addCategory(category);
	}
	
	@Transactional
	public List<Category> getAllCategories() {
		return this.categoryDaoImpl.getAllCategories();
	}
	

}
