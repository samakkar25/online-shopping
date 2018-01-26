package com.app.fantastic.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.fantastic.Aweb.dao.CategoryDAO;

public class CategoryTest {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	//private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.app.fantastic.Aweb");
		
		System.out.println("1");
		context.refresh();
		
		System.out.println("2");
		categoryDAO = (CategoryDAO) context.getBean("dao");
		System.out.println(categoryDAO);
		
	}
	
	/*
	@Test
	public void testAddCategory() throws SQLException {
		System.out.println("starting test");
		category = new Category();
		category.setName("TV");
		category.setDescription("This is dec for TV");
		category.setImageURL("CAT_1.png");
		
		boolean b = categoryDAO.add(category);
		System.out.println(b);
		assertEquals("Successfully added the catefory inside table", true, b);
		
		System.out.println("ending test");
try
{ 
     Class.forName("org.h2.Driver");          
     Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/onlineshopping","sa","");  
     conn.close();
}
catch(ClassNotFoundException ex)
{
     System.out.println( "ERROR: Class not found: " + ex.getMessage()); 
}

	}
	*/
	
	
	/*
	@Test
	public void getTestCategory() {
		category = categoryDAO.get(3);
		assertEquals("Test for TV", "Mobile", category.getName());
	}
	*/
	/*
	@Test
	public void testupdateCategory() {
		category = categoryDAO.get(4);
		category.setName("Heater");
		assertEquals("Test for TV", true, categoryDAO.update(category));
	}
	*/
	
	
	/*
	@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(6);
		
		assertEquals("Test for TV", true, categoryDAO.delete(category));
	}
	*/
	
	/*
	@Test
	public void testListCategory() {
		assertEquals("get all category", 4, categoryDAO.list().size());	
	}
	*/
	
}
