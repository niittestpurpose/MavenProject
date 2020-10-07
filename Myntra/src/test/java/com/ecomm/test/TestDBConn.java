package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;


import entity.MyCategory;

public class TestDBConn 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		
		MyCategory category=new MyCategory();
		category.setCategoryName("Motorola");
		category.setCategoryDesc("All Models of Motorola Mobile");
		
		CategoryDAO categoryDAO=(CategoryDAO)appContext.getBean("categoryDAO");
		if(categoryDAO.addCategory(category))
		{
			System.out.println("Object Saved");
		}
		else
		{
			System.out.println("Problem Occured");
		}
	}
}
