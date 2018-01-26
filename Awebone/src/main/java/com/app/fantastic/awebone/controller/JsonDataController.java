package com.app.fantastic.awebone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.fantastic.Aweb.dao.ProductDAO;
import com.app.fantastic.Aweb.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO; 
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActiveProducts();
		
	}
	
	
	@RequestMapping("category/{id}/products")
	@ResponseBody
	public List<Product> getCategoryProducts(@PathVariable int id) {
		
		return productDAO.listActiveProductsByCategory(id);
		
	}
}
