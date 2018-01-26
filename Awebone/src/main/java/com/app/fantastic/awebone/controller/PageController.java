package com.app.fantastic.awebone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.fantastic.Aweb.dao.CategoryDAO;
import com.app.fantastic.Aweb.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv =  new ModelAndView("page");
		mv.addObject("title", "Flipkart");
		mv.addObject("userClicksHome", true);
		System.out.println(categoryDAO.list());
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	
	
	@RequestMapping(value = {"contact"})
	public ModelAndView contact() {
		ModelAndView mv =  new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClicksContact", true);
		
		return mv;
	}
	
	
	
	@RequestMapping(value = {"about"})
	public ModelAndView about() {
		ModelAndView mv =  new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClicksAbout", true);
		
		return mv;
	}
	
	/*
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
		if (greeting==null) {
			greeting = "Hello There";
		}
		ModelAndView mv =  new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}	
	*/
	
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView testpath(@PathVariable("greeting")String greeting) {
		if (greeting==null) {
			greeting = "Hello There";
		}
		ModelAndView mv =  new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	/*
	Method to load all the product
	*/
	
	

	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv =  new ModelAndView("page");
		
		mv.addObject("title", "All Products");
		mv.addObject("userClicksAllProducts", true);
		
		System.out.println(categoryDAO.list());
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showAllProducts(@PathVariable("id") int id) {
		
		ModelAndView mv =  new ModelAndView("page");
		
		//categoryDAO to fetch a single category 
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		mv.addObject("userClicksCategoryProducts", true);
		
		System.out.println(categoryDAO.list());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		return mv;
	}
		
}
