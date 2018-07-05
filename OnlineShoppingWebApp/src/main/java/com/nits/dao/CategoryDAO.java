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
	
	boolean add(Category category);
	
	List<Category> list();

	Category get(int categoryID);

}
