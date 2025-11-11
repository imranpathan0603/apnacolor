package com.apnacolor.request;

import java.util.Date;

import com.apnacolor.entity.Product;

public class FeedbackDto {
	private Long id;
	private Long userId;
	private String username;
	private String message;

	private Long product;
	private long productId;
	private String productName;
	private Date date;

	

	public FeedbackDto(Long id, Long userId, String username, String message, Date date, Long productId,String productName , long produId) {
	    this.id = id;
	    this.userId = userId;
	    this.username = username;
	    this.message = message;
	    this.date = date;
	    this.product = productId;
	    this.productName=productName;
	    this.productId=produId;
	    
	}


	public String getProductName() {
		return productName;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Date getDate() {
	    return date;
	}

	public void setDate(Date date) {
	    this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	// Getters and Setters

}
