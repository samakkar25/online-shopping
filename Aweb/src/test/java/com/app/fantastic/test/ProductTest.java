package com.app.fantastic.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.fantastic.Aweb.dao.ProductDAO;
import com.app.fantastic.Aweb.dto.Product;

public class ProductTest {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.app.fantastic.Aweb");
		
		System.out.println("1");
		context.refresh();
		
		System.out.println("2");
		productDAO = (ProductDAO) context.getBean("prodDAO");
		System.out.println(productDAO);
		
	}
	
	@Test
	public void testCRUDProduct() {
		product = new Product();
		
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		System.out.println(productDAO.add(product));
		
	}
	
	
}
