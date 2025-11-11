package com.apnacolor.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnacolor.entity.Bill;
import com.apnacolor.entity.BillDetails;
import com.apnacolor.entity.CartItem;
import com.apnacolor.entity.Product;
import com.apnacolor.entity.User;
import com.apnacolor.repository.BillDetailsRepository;
import com.apnacolor.repository.BillRepository;
import com.apnacolor.repository.CartItemRepository;
import com.apnacolor.request.BillItemDto;
import com.apnacolor.request.BillResponse;

import jakarta.transaction.Transactional;

@Service
public class BillingServiceImpl {

	@Autowired
	private CartItemRepository cartRepository;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillDetailsRepository billDetailsRepo;

	@Transactional
	public Bill createBillFromCart(List<Long> cartIds, String paymentMethod) {
	    System.out.println("Requested cart IDs: " + cartIds);
	    List<CartItem> cartItem = cartRepository.findAllById(cartIds);
	    System.out.println("Found cart items: " + cartItem.size());
	    if (cartItem.isEmpty()) {
	        throw new IllegalArgumentException("No cart items found for IDs: " + cartIds);
	    }

//		User user =cartItem.get(0).getUserId(); 
		User user = cartItem.get(0).getUser();

		BigDecimal total = BigDecimal.ZERO;

		Bill bill = new Bill();
		bill.setInvoiceNo("INV-" + System.currentTimeMillis());
		bill.setUser(user);
		bill.setDate(LocalDateTime.now());
		bill.setPaymentMethod(paymentMethod);
		billRepository.save(bill);
		
		for(CartItem cart :cartItem){
			Product p = cart.getProduct();
			BigDecimal price = BigDecimal.valueOf(p.getPrice()); // Convert double → BigDecimal
			BigDecimal qty = BigDecimal.valueOf(cart.getQuantity());

			BigDecimal subtotal = price.multiply(qty); // ✅ OK!
			
			
			BillDetails bd =new BillDetails();
			bd.setBill(bill);
			bd.setProduct(p);
			bd.setQuantity(cart.getQuantity());
			bd.setPrice(BigDecimal.valueOf(p.getPrice()));
			bd.setSubTotle(subtotal);
			billDetailsRepo.save(bd);
			
			total=total.add(subtotal);
		}
			bill.setTotalAmount(total);
			billRepository.save(bill);

		return bill;
	}
	
	
	public BillResponse getBillDtoById(Long billId) {
	    Bill bill = billRepository.findById(billId)
	            .orElseThrow(() -> new RuntimeException("Bill not found with id: " + billId));

	    List<BillDetails> billDetails = billDetailsRepo.findByBillId(billId);

	    List<BillItemDto> items = billDetails.stream()
	            .map(detail -> new BillItemDto(
	                    detail.getProduct().getName(),
	                    detail.getPrice().doubleValue(),
	                    detail.getQuantity(),
	                    detail.getSubTotle()
	            ))
	            .toList();

	    return new BillResponse(
	    	    bill.getId(),  // 👈 Add this
	    	    bill.getInvoiceNo(),
	    	    bill.getUser().getUsername(),
	    	    bill.getDate(),
	    	    bill.getPaymentMethod(),
	    	    bill.getStatus(),
	    	    bill.getTotalAmount(),
	    	    items
	    	);
	}


}
