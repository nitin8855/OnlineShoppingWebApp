/**
 * 
 */
package com.nits.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nits.dao.CategoryDAO;
import com.nits.dto.Category;

/**
 * @author nitin
 *
 */
@Repository("categoryDAO")
public class CatagoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category =new Category();
		
		category.setCategoryID(1);
		category.setName("Laptop");
		category.setDiscription("Laptop");
		category.setImageURL("CAT-1.png");
		
		categories.add(category);
		
	    category =new Category();
		category.setCategoryID(2);
		category.setName("Mobile");
		category.setDiscription("mob");
		category.setImageURL("CAT-2.png");
		
		categories.add(category);
		
		category =new Category();
		category.setCategoryID(3);
		category.setName("TV");
		category.setDiscription("tv");
		category.setImageURL("CAT-3.png");
		
		categories.add(category);
		System.out.println(categories.size());
		
	}

	/* (non-Javadoc)
	 * @see com.nits.dao.CategoryDAO#list()
	 */
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
