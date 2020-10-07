package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Product;

@Controller
public class ProductController 
{
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct")
	public String insertProductPage(@ModelAttribute("product")Product product,Model m)
	{
		System.out.println("Product Name:"+product.getProductName());
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		return "Product";
	}
	
}
