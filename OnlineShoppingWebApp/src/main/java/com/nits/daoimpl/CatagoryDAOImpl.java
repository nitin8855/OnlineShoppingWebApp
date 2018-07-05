/**
 * 
 */
package com.nits.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nits.dao.CategoryDAO;
import com.nits.dto.Category;

/**
 * @author nitin
 *
 */
@Repository("categoryDAO")
@Transactional
public class CatagoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	/*@Autowired
	private CategoryDAO categoryDAO;*/

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nits.dao.CategoryDAO#list()
	 */
	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category  WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}
	

	/* (non-Javadoc)
	 * Get single category
	 * @see com.nits.dao.CategoryDAO#get(int)
	 */
	@Override
	public Category get(long categoryID) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().get(Category.class, Long.valueOf(categoryID));
	}

	@Override
	public boolean add(Category category) {
		
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean udate(Category category) {
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			
			return true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			
			return true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
