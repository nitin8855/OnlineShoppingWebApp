/**
 * 
 */
package com.nits.onlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nits.dao.CategoryDAO;
import com.nits.dto.Category;

/**
 * @author nitin
 *
 */

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/index","/home"})
	public ModelAndView index() {
		ModelAndView mav =new ModelAndView("page");
		mav.addObject("title", "Home");
		mav.addObject("categories", categoryDAO.list());
		//System.out.println(categoryDAO.list());
		mav.addObject("userClickHome", true);
		return mav;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView About() {
		ModelAndView mav =new ModelAndView("page");
		mav.addObject("title", "About Us");
		mav.addObject("userClickAbout", true);
		return mav;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView Contact() {
		ModelAndView mav =new ModelAndView("page");
		mav.addObject("title", "Contact Us");
		mav.addObject("userClickContact", true);
		return mav;
	}
	
	/*
	 * show all product and based on product
	 * */
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mav =new ModelAndView("page");
		mav.addObject("title", "All Products");
		//passing list of products
		mav.addObject("categories", categoryDAO.list());
		
		System.out.println(categoryDAO.list());
		mav.addObject("userClickAllProducts", true);
		return mav;
	}
	
	@RequestMapping(value= "/show/category/{categoryID}/products")
	public ModelAndView showCategoryProducts(@PathVariable("categoryID") int categoryID) {
		ModelAndView mav =new ModelAndView("page");
		//catagoryDAO to fetch single category
		Category category =null;
		
		category=categoryDAO.get(categoryID);
		mav.addObject("title", category.getName());
		//passing list of products
		mav.addObject("categories", categoryDAO.list());
		//passing the single category objects
		mav.addObject("category", category);
		System.out.println(categoryDAO.list());
		mav.addObject("userClickCategoryProduct", true);
		return mav;
	}

	

}
