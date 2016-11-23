package com.ecommerce.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.model.Role;
import com.ecommerce.model.User;
import com.ecommerce.model.UserCustomer;
import com.ecommerce.service.*;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		
		/*Role role = (Role) context.getBean("role");
		RoleService roleService = (RoleService) context.getBean("roleService");
		role = roleService.getRole(1);
		System.out.println("Fetched role : " + role.getName());*/
		
		//Creating user data 
		/*UserService userService = (UserService) context.getBean("userService");
		User user = (User) context.getBean("user");*/
		
		
		//Creating customer data
		UserCustomerService userCustomerService = (UserCustomerService) context.getBean("userCustomerService");
		UserCustomer customer = (UserCustomer) context.getBean("userCustomer");
		customer = userCustomerService.findCustomer("m@test.com", "delhi");
		System.out.println("Found customer ");
		System.out.println("customer " + customer.getBilling_address());
		
		
		
		/*user = userService.getUserByEmail("p@test.com");
		System.out.println("User: " + user.getFirst_name());*/
		
		
		
		
		context.close();
	}

}
