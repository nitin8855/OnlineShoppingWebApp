/**
 * 
 */
package com.nits.dao;

import java.util.List;

import com.nits.dto.Product;

/**
 * @author nitin
 *
 */
public interface ProductDAO {
	
	Product get (long l);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<Product> listActiveProduct();
	List<Product> lsitActiveProductByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);

}
