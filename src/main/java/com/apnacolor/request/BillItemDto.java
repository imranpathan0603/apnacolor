package com.apnacolor.request;


import java.math.BigDecimal;

public class BillItemDto {
    private String productName;
    private double price;
    private int quantity;
    private BigDecimal subtotal;

    public BillItemDto(String productName, double price, int quantity, BigDecimal subtotal) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

    
    // Getters & Setters
}
