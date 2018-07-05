/**
 * 
 */
package com.nits.dao;

import java.util.List;

import com.nits.dto.Category;

/**
 * @author nitin
 *
 */
public interface CategoryDAO {
	
	
	Category get(long categoryID);
	List<Category> list();
	boolean add(Category category);
	boolean udate(Category category);
	boolean delete(Category category);
	

}
