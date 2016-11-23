package com.ecommerce.service;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Role;

@Service
public interface RoleService {
	public int addRole(Role user);
	public Role getRole(int userId);
	public void updateRole(Role user);
	public boolean deleteRole(int userId);
	public List<Role> getAllRoles();
}
