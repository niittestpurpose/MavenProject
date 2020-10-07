package com.ecomm.dao;

import java.util.List;

import entity.MyCategory;

public interface CategoryDAO 
{
	public boolean addCategory(MyCategory category);
	public boolean deleteCategory(MyCategory category);
	public boolean updateCategory(MyCategory category);
	public List<MyCategory> getCategoryDetails();
	public MyCategory getCategory(int categoryId);
}
