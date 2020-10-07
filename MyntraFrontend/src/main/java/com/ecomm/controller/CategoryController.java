package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;

import entity.MyCategory;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping(value="/showCategory")
	public String showCategory(Model m)
	{
		List<MyCategory> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		MyCategory categoryObj=new MyCategory();
		categoryObj.setCategoryName(categoryName);
		categoryObj.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(categoryObj);
		
		List<MyCategory> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId")int categoryId,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		MyCategory categoryObj=categoryDAO.getCategory(categoryId);
		categoryObj.setCategoryName(categoryName);
		categoryObj.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(categoryObj);
		
		List<MyCategory> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		MyCategory categoryObj=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(categoryObj);
		
		List<MyCategory> categoryList=categoryDAO.getCategoryDetails();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		MyCategory categoryObj=categoryDAO.getCategory(categoryId);
		m.addAttribute("category", categoryObj);
		return "CategoryUpdate";
	}
}
