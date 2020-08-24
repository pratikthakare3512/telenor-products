package com.telenor.products.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String productType;
	private Integer price;
	private String city;
	private String attribute;
	private String value;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Product(String productType, Integer price, String city, String attribute, String value) {
		this.productType = productType;
		this.price = price;
		this.city = city;
		this.attribute = attribute;
		this.value = value;
	}
	public Product() {
	}
	@Override
	public String toString() {
		return "Product [productType=" + productType + ", price=" + price + ", city=" + city + ", attribute="
				+ attribute + ", value=" + value + "]";
	}
	
}
