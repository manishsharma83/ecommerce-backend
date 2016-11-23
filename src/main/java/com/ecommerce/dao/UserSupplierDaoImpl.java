package com.ecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.UserSupplier;


@Repository (value="userSupplierDao")
@Transactional
public class UserSupplierDaoImpl implements UserSupplierDao{

	@Autowired
	private SessionFactory session;
	
	public int addSupplier(UserSupplier supplier) {
		session.getCurrentSession().save(supplier);
		int id = supplier.getId();
		
		return id;
	}

	public UserSupplier getSupplier(int userId) {
		return session.getCurrentSession().get(UserSupplier.class, userId);
	}

	public void updateSupplier(UserSupplier supplier) {
		session.getCurrentSession().update(supplier);
	}

	public boolean deleteSupplier(int userId) {
		session.getCurrentSession().delete(userId);
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<UserSupplier> getAllSuppliers() {
		return (List<UserSupplier>) session.getCurrentSession().createQuery("from UserSupplier").list();
	}
	
}
