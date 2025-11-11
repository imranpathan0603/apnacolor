package com.apnacolor.services;

import java.util.List;

import com.apnacolor.entity.CartItem;

public interface CartItemService {
    CartItem addToCart(Long userId, Long productId, int quantity);
    List<CartItem> getCartItems(Long userId);
    CartItem updateQuantity(Long cartItemId, int quantity);
    boolean removeFromCart(Long cartItemId);
}
