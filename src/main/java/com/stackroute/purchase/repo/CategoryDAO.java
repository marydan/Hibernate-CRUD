package com.stackroute.purchase.repo;

import java.util.List;

import com.stackroute.purchase.model.Category;

public interface CategoryDAO {
 
	public void addCategory(Category obj);
	public void deleteCategory(int catid);
	public void updCategory(Category obj);
	public Category findByCategoryId(int catid);
	public List<Category> findallCategory();
	
}
