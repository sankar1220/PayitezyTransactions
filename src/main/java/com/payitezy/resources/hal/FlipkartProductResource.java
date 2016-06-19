package com.payitezy.resources.hal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlipkartProductResource extends ResourceSupport {
	private String productId;
	private String categorytitle;
	private String title;
	private String productDescription;
	private String imageUrl;
	private String mrp;
	private String sellingPrice;
	private String productUrl;
	private String inStock;
	private String isAvailabile;
	private String emiAvailable;
	private String discountPercentage;
	private String cashBack;
	private String size;
	private String color;
	public FlipkartProductResource(@JsonProperty("productId")String productId,@JsonProperty("categorytitle") String categorytitle,
			@JsonProperty("title")String title,@JsonProperty("productDescription") String productDescription, @JsonProperty("imageUrl")String imageUrl,
			@JsonProperty("mrp")String mrp, @JsonProperty("sellingPrice")String sellingPrice, @JsonProperty("productUrl")String productUrl, @JsonProperty("inStock")String inStock,
			@JsonProperty("isAvailabile")String isAvailabile, @JsonProperty("emiAvailable")String emiAvailable,
			@JsonProperty("discountPercentage")String discountPercentage, @JsonProperty("cashBack")String cashBack, @JsonProperty("size")String size,
			@JsonProperty("color")String color, @JsonProperty("sizeUnit")String sizeUnit, @JsonProperty("productBrand")String productBrand) {
		super();
		this.productId = productId;
		this.categorytitle = categorytitle;
		this.title = title;
		this.productDescription = productDescription;
		this.imageUrl = imageUrl;
		this.mrp = mrp;
		this.sellingPrice = sellingPrice;
		this.productUrl = productUrl;
		this.inStock = inStock;
		this.isAvailabile = isAvailabile;
		this.emiAvailable = emiAvailable;
		this.discountPercentage = discountPercentage;
		this.cashBack = cashBack;
		this.size = size;
		this.color = color;
		this.sizeUnit = sizeUnit;
		this.productBrand = productBrand;
	}
	private String sizeUnit;
	private String productBrand;
	
	
	
	public String getCategorytitle() {
		return categorytitle;
	}
	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getMrp() {
		return mrp;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public String getInStock() {
		return inStock;
	}
	public void setInStock(String inStock) {
		this.inStock = inStock;
	}
	public String getIsAvailabile() {
		return isAvailabile;
	}
	public void setIsAvailabile(String isAvailabile) {
		this.isAvailabile = isAvailabile;
	}
	public String getEmiAvailable() {
		return emiAvailable;
	}
	public void setEmiAvailable(String emiAvailable) {
		this.emiAvailable = emiAvailable;
	}
	public String getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getCashBack() {
		return cashBack;
	}
	public void setCashBack(String cashBack) {
		this.cashBack = cashBack;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSizeUnit() {
		return sizeUnit;
	}
	public void setSizeUnit(String sizeUnit) {
		this.sizeUnit = sizeUnit;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
