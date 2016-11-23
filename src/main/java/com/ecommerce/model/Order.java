package com.ecommerce.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "orders")
@Component
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String order_no;
	
	private double total_amount;

	@Temporal(TemporalType.TIMESTAMP)
    private Date created_on=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Version
    private Date updated_on;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "user_id")
	private UserCustomer customer;
	
	@OneToMany
	private List<OrderDetails> orderDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no() {
		UUID uid = UUID.fromString("58D5E212-165B-4CA0-909B-C86B9CEE0111");
		this.order_no = uid.randomUUID().toString();
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public UserCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(UserCustomer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
