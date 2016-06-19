package com.payitezy.apiobjects;

public class ProductDetails {

	
	private String product_name;
	private String product_model;
	private String product_main_category;
	private String product_sub_category;
	private String isavilable;
	private String[] product_image_full;
	private String[] product_image_single;
	private String[] product_image_thumbnail;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String[] getProduct_image_single() {
		return product_image_single;
	}
	public void setProduct_image_single(String[] product_image_single) {
		this.product_image_single = product_image_single;
	}
	public String[] getProduct_image_thumbnail() {
		return product_image_thumbnail;
	}
	public void setProduct_image_thumbnail(String[] product_image_thumbnail) {
		this.product_image_thumbnail = product_image_thumbnail;
	}
	public String getProduct_model() {
		return product_model;
	}
	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}
	public String getProduct_main_category() {
		return product_main_category;
	}
	public void setProduct_main_category(String product_main_category) {
		this.product_main_category = product_main_category;
	}
	public String getProduct_sub_category() {
		return product_sub_category;
	}
	public void setProduct_sub_category(String product_sub_category) {
		this.product_sub_category = product_sub_category;
	}
	
	
	public String getIsavilable() {
		return isavilable;
	}
	public void setIsavilable(String isavilable) {
		this.isavilable = isavilable;
	}
	public String[] getProduct_image_full() {
		return product_image_full;
	}
	public void setProduct_image_full(String[] product_image_full) {
		this.product_image_full = product_image_full;
	}
	
	}
