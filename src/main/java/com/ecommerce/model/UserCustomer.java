package com.ecommerce.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity 
@Table (name = "user_customers")
@Component
public class UserCustomer{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne 
	@JoinColumn(name="user_id",referencedColumnName="id")
	private User user;
	
	private String mobile_no;
	private String billing_address;
	private String shipping_address;
	@Transient
	private String cardno;
	private String cardno_last4digit;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getBilling_address() {
		return billing_address;
	}

	public void setBilling_address(String billing_address) {
		this.billing_address = billing_address;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardno_last4digit() {
		return cardno_last4digit;
	}

	public void setCardno_last4digit(String cardno_last4digit) {
		this.cardno_last4digit = cardno_last4digit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
