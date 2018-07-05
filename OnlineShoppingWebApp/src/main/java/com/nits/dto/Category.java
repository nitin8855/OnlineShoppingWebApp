/**
 * 
 */
package com.nits.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author nitin
 *
 */
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryID;
	private String name;
	private String discription;
	
	@Column(name = "image_url")
	private String imageURL;
	
	@Column(name = "is_active")
	private boolean active= true;
	
	//setter and getter
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", name=" + name + ", discription=" + discription + ", imageURL="
				+ imageURL + ", active=" + active + "]";
	}
	
	

}
