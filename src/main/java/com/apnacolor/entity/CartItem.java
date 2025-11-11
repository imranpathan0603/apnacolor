package com.apnacolor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addtocart")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Assuming userId is stored for multi-user carts
//    private Long userId;
    
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private int quantity;

    public CartItem() {}

    public CartItem(User user, Product product, int quantity) {
//        this.userId = userId;
    	this.user=user;
        this.product = product;
        this.quantity = quantity;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getUserId() {
//		return userId;
//	}

//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    // getters and setters
    
}
