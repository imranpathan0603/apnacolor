package com.apnacolor.entity;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String contactNo;
    
    private String email;

    private String address;

    private String password;

    private String role; // e.g., "USER" or "ADMIN"
    
//    @Lob
//    @Column(columnDefinition = "longblob")
//    private Byte img[];

    
    
    
//    getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public Byte[] getImg() {
//		return img;
//	}
//
//	public void setImg(Byte[] img) {
//		this.img = img;
//	}


    
    
    
    
    



    

    
} 
