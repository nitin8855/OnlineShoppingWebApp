/**
 * 
 */
package com.nits.dto;

/**
 * @author nitin
 *
 */
public class Category {
	
	private long categoryID;
	private String name;
	private String discription;
	private String imageURL;
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
