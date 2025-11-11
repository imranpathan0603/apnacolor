package com.apnacolor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnacolor.entity.CartItem;
import com.apnacolor.entity.Product;
import com.apnacolor.entity.User;
import com.apnacolor.repository.CartItemRepository;
import com.apnacolor.repository.ProductRepository;
import com.apnacolor.repository.UserRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CartItem addToCart(Long userId, Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        // Check if product already in cart for user, then update quantity
        List<CartItem> userCartItems = cartItemRepository.findByUserId(userId);
        Optional<CartItem> existing = userCartItems.stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst();

        if (existing.isPresent()) {
            CartItem item = existing.get();
            item.setQuantity(item.getQuantity() + quantity);
            return cartItemRepository.save(item);
        } else {
            CartItem newItem = new CartItem(user, product, quantity);
            return cartItemRepository.save(newItem);
        }
    }

    @Override
    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }
    


    @Override
    public CartItem updateQuantity(Long cartItemId, int quantity) {
        Optional<CartItem> item = cartItemRepository.findById(cartItemId);
        if (item.isPresent()) {
            CartItem cartItem = item.get();
            cartItem.setQuantity(quantity);
            return cartItemRepository.save(cartItem);
        }
        throw new RuntimeException("Cart item not found");
    }

    @Override
    public boolean removeFromCart(Long cartItemId) {
        if (cartItemRepository.existsById(cartItemId)) {
            cartItemRepository.deleteById(cartItemId);
            return true;
        }
        return false;
    }
}
