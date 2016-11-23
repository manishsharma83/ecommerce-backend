package com.ecommerce.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.model.*;
import com.ecommerce.service.*;

public class PrepareTestData {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecommerce");
		context.refresh();
		System.out.println("context.refresh done");
		
		// Creating role data
		RoleService roleService = (RoleService) context.getBean("roleService");
		Role role = (Role) context.getBean("role");
		/*role.setName("Customer");
		roleService.addRole(role);
		System.out.println("role data created");*/
		
		// Fetching Customer Role
		role = roleService.getRole(1);
		System.out.println("Fetched role : " + role.getName());
		
		
		UserService userService = (UserService) context.getBean("userService");
		User user = (User) context.getBean("user");
		
		//Creating user data 
		/*user.setEmail("m@test.com");
		user.setPassword("test@123");
		user.setCpassword("test@123");
		user.setFirst_name("Manish");
		user.setLast_name("Sharma");
		user.setRole(role);
		
		userService.addUser(user);
		System.out.println("user object created");*/
		
		
		UserCustomerService userCustomerService = (UserCustomerService) context.getBean("userCustomerService");
		UserCustomer customer = (UserCustomer) context.getBean("userCustomer");
		
		//Creating customer data
		/*customer.setMobile_no("1234567890");
		customer.setBilling_address("123, Some Address, Delhi");
		customer.setShipping_address("123, Some Address, Delhi");
		customer.setCardno("1234 1234 1234 1234");
		customer.setUser(user);
		
		userCustomerService.addCustomer(customer);
		System.out.println("customer object created");*/
		
		// Fetching customer data
		customer = userCustomerService.getCustomer(1);
		System.out.println("Fetched customer : " + customer.getUser().getFirst_name());
		
		
		UserSupplierService supplierService = (UserSupplierService) context.getBean("userSupplierService");
		UserSupplier supplier = (UserSupplier) context.getBean("userSupplier");
		
		/*role.setName("Supplier");
		roleService.addRole(role);
		System.out.println("Supplier role data created");*/
		
		//Creating user data 
		/*user.setEmail("s@test.com");
		user.setPassword("test@123");
		user.setCpassword("test@123");
		user.setFirst_name("Robin");
		user.setLast_name("Singha");
		user.setRole(role);
		
		userService.addUser(user);
		System.out.println("user object created");*/
		
		// creating supplier
		/*supplier.setUser(user);
		supplierService.addSupplier(supplier);
		System.out.println("supplier object created");*/
		
		// Fetching supplier data
		supplier = supplierService.getSupplier(1);
		System.out.println("Fetched supplier : " + supplier.getUser().getFirst_name());
		
		
		
		
		ProductCategoryService productCategoryService = (ProductCategoryService) context.getBean("productCategoryService");
		ProductCategory productCategory = (ProductCategory) context.getBean("productCategory");
		
		// creating product category
		/*productCategory.setName("Electronics");
		productCategoryService.addProductCategory(productCategory);
		System.out.println("productCategory object created");*/
		
		// Fetching productCategory data
		productCategory = productCategoryService.getProductCategory(1);
		System.out.println("Fetched productCategory : " + productCategory.getName());
				
		ProductService productService = (ProductService) context.getBean("productService");
		Product product = (Product) context.getBean("product");
		
		// creating product
		/*product.setName("Apple IPad Mini 2");
		product.setDescription("Apple IPad Mini 2 Desc");
		product.setPrice(16000);
		product.setType("T1");
		product.setProductCategory(productCategory);
		productService.addProduct(product);
		System.out.println("product object created");*/
		
		// Fetching product data
		product = productService.getProduct(1);
		System.out.println("Fetched product : " + product.getName());
		
		
		
		InventoryService inventoryService = (InventoryService) context.getBean("inventoryService");
		Inventory inventory = (Inventory) context.getBean("inventory");
		
		/*inventory.setProduct(product);
		inventory.setSupplier(supplier);
		inventory.setQuantity(100);
		
		inventoryService.addProductInventory(inventory);
		System.out.println("inventory object created");*/
		
		// Fetching inventory data
		//System.out.println("Fetched supplier.getUser().getId() : " + supplier.getUser().getId());
		//System.out.println("Fetched product.getId() : " + product.getId());
		//inventory = inventoryService.getProductInventoryBySupplier(supplier, product);
		
		//System.out.println("Fetched inventory : " + inventory.getQuantity());
		
		
		System.out.println("===Fetched inventory using HQL=== ");
		inventory = inventoryService.getProductInventoryBySupplierHQL(supplier.getUser().getId(), product.getId());
		
		
		System.out.println("Fetched inventory : " + inventory.getQuantity());
		
		
		
		
		
		OrderService orderService = (OrderService) context.getBean("orderService");
		Order order = (Order) context.getBean("order");
		
		
		
		
		
		OrderDetailsService orderDetailsService = (OrderDetailsService) context.getBean("orderDetailsService");
		OrderDetails orderDetails = (OrderDetails) context.getBean("orderDetails");
		
		orderDetails.setOrder(order);
		orderDetails.setProduct(product);
		orderDetails.setQuantity(4);
		
		order.setOrder_no();
		order.setCustomer(customer);
		order.setTotal_amount(product.getPrice() * orderDetails.getQuantity());
		
		orderService.addOrder(order);
		orderDetailsService.addOrderItem(orderDetails);
		System.out.println("Order Added");
		
		order = orderService.getOrder(1);
		System.out.println("Fetched Order: "+ order.getId());
		context.close();
	}

}
