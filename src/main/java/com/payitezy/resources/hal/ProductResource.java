package com.payitezy.resources.hal;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResource extends ResourceWithEmbeddeds {
	private String product_title;
	private String product_lowest_price;
	private String product_link;
	private String product_category;
	private String product_sub_cate;
	private String product_image;
	
	@JsonCreator
	public ProductResource(@JsonProperty("product_title")String product_title, @JsonProperty("product_lowest_price")String product_lowest_price,
			@JsonProperty("product_link")String product_link, @JsonProperty("product_category")String product_category,
			@JsonProperty("product_sub_cate")String product_sub_cate, @JsonProperty("product_image")String product_image) {
		super();
		this.product_title = product_title;
		this.product_lowest_price = product_lowest_price;
		this.product_link = product_link;
		this.product_category = product_category;
		this.product_sub_cate = product_sub_cate;
		this.product_image = product_image;
	}
	
	
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public String getProduct_lowest_price() {
		return product_lowest_price;
	}
	public void setProduct_lowest_price(String product_lowest_price) {
		this.product_lowest_price = product_lowest_price;
	}
	public String getProduct_link() {
		return product_link;
	}
	public void setProduct_link(String product_link) {
		this.product_link = product_link;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_sub_cate() {
		return product_sub_cate;
	}
	public void setProduct_sub_cate(String product_sub_cate) {
		this.product_sub_cate = product_sub_cate;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
}
