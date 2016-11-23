package com.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.*;

@Repository
public interface OrderDao {
	public int addOrder(Order order);
	public Order getOrder(int orderId);
	public void updateOrder(Order order);
	public boolean deleteOrder(int orderId);
	public List<Order> getAllOrders();
}
