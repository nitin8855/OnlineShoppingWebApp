/**
 * 
 */
package com.nits.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nits.dao.ProductDAO;
import com.nits.dto.Product;

/**
 * @author nitin
 *
 */
public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.nits");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		
		//create new product
		product = new Product();
		
		product.setName("This is Product Name");
		product.setBrand("LG");
		product.setDescription("This is description of product LG");
		product.setUnitPrice(30000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(2);
		
		//assertEquals("not inserting new product",true,productDAO.add(product));
		/*
		//reading and updating the category
		product = productDAO.get(7L);
		product.setName("Samsung Galaxy");
		
		assertEquals("problem while updating",true,productDAO.update(product));
		
		//deleting product
		assertEquals("problem while deleting",true,productDAO.delete(product));
		
		//List of product 
		assertEquals("problem while getting all Product",1,productDAO.list().size());*/
	}

	/*@Test
	public void testListActiveProducts() {
		assertEquals("problem while getting List active Product",1,productDAO.listActiveProduct().size());

	}*/
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("problem while getting List of active Product by categoryId",1,productDAO.lsitActiveProductByCategory(3).size());

	}
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("problem while getting List of active Product by categoryId",1,productDAO.getLatestActiveProducts(3).size());

	}
}
