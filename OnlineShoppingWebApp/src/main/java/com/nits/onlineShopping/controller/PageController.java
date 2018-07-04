/**
 * 
 */
package com.nits.onlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nits.dao.CategoryDAO;

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
		System.out.println(categoryDAO.list());
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
	
	

	

}
