package com.apnacolor.request;

import java.util.List;

public class BillingRequest {
    private List<Long> cartIds;
    private String paymentMethod;
	public List<Long> getCartIds() {
		return cartIds;
	}
	public void setCartIds(List<Long> cartIds) {
		this.cartIds = cartIds;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
    
    
}
