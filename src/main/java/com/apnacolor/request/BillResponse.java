package com.apnacolor.request;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BillResponse {
	private Long id;
    private String invoiceNo;
    private String username;
    private LocalDateTime date;
    private String paymentMethod;
    private String status;
    
    private BigDecimal totalAmount;
    
    private List<BillItemDto> items;

    public BillResponse(Long id, String invoiceNo, String username, LocalDateTime date, String paymentMethod,
            String status, BigDecimal totalAmount, List<BillItemDto> items) {
this.id = id;
this.invoiceNo = invoiceNo;
this.username = username;
this.date = date;
this.paymentMethod = paymentMethod;
this.status = status;
this.totalAmount = totalAmount;
this.items = items;
}


	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<BillItemDto> getItems() {
		return items;
	}

	public void setItems(List<BillItemDto> items) {
		this.items = items;
	}

	public Long getBillid() {
		return id;
	}

	public void setBillid(Long id) {
		this.id = id;
	}

    // Getters & Setters
    
    
    
}

