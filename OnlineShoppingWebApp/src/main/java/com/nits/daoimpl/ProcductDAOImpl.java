/**
 * 
 */
package com.nits.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nits.dao.ProductDAO;
import com.nits.dto.Product;

/**
 * @author nitin
 *
 */

@Repository("productDAO")
@Transactional
public class ProcductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory  sessionFactory ;

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#get(int)
	 */
	@Override
	public Product get(long productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, productId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
		}
	

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#list()
	 */
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#add(com.nits.dto.Product)
	 */
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#update(com.nits.dto.Product)
	 */
	@Override
	public boolean update(Product product) {
		try {
			 sessionFactory.getCurrentSession().update(product);
			 return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#delete(com.nits.dto.Product)
	 */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#listActiveProduct()
	 */
	@Override
	public List<Product> listActiveProduct() {
		String selectActiveProduct = "FROM Product WHERE active = :active";

		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProduct, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#lsitActiveProductByCategory(int)
	 */
	@Override
	public List<Product> lsitActiveProductByCategory(int categoryId) {
		String selectActiveProductAndCategoryId = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductAndCategoryId, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.nits.dao.ProcductDAO#getLatestActiveProducts(int)
	 */
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String latestActiveProducts = "FROM Product WHERE active = :active ORDER By id ";
		return sessionFactory.getCurrentSession()
				.createQuery(latestActiveProducts, Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
