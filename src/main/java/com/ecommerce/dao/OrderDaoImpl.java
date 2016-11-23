package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Order;


@Repository (value="orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private SessionFactory session;
	
	public int addOrder(Order order) {
		session.getCurrentSession().save(order);
		int id = order.getId();
		
		return id;
	}

	public Order getOrder(int orderId) {
		return session.getCurrentSession().get(Order.class, orderId);
	}

	public void updateOrder(Order order) {
		session.getCurrentSession().update(order);
	}

	public boolean deleteOrder(int orderId) {
		session.getCurrentSession().delete(orderId);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		return (List<Order>) session.getCurrentSession().createQuery("from Order").list();
	}
	
}
