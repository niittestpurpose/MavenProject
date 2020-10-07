package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;

import entity.MyCategory;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		categoryDAO=(CategoryDAO)appContext.getBean("categoryDAO");
	}

	
	@Test
	public void addCategory()
	{
		MyCategory category=new MyCategory();
		category.setCategoryName("Vivo");
		category.setCategoryDesc("All Mobile Brands of Vivo");
		
		assertTrue("Problem in Inserting Category",categoryDAO.addCategory(category));
	}
	
	@Test
	public void getCategoryTest()
	{
		MyCategory category=(MyCategory)categoryDAO.getCategory(5);
		assertNotNull("category object not Found",category);
		System.out.println("Category Name:"+category.getCategoryName());
		System.out.println("Category Desc:"+category.getCategoryDesc());
	}
	
	@Test
	public void getCatgoryList()
	{
		List<MyCategory> categoryList=(List<MyCategory>)categoryDAO.getCategoryDetails();
		
		for(MyCategory category:categoryList)
		{
			System.out.print("Category Name:"+category.getCategoryName());
			System.out.println("::::Category Desc:"+category.getCategoryDesc());
		}
	}
}
