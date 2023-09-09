package com.jsp.controller;

import com.jsp.dto.Customer;

import service.CustomerService;

public class CustomerController {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(6);
		customer.setName("Khemraj");
		customer.setEmail("khemraj@mail.com");
		customer.setPh_no(9234567890L);
		
		//=====>Save Customer
//		CustomerService customerService = new CustomerService();
//		Customer c =  customerService.saveCustomer(customer);
//		if(c!=null) {
//			System.out.println(c.getName()+" saved successfully");
//		}
		
		
		
		//=====>Delete Student
//		CustomerService customerService = new CustomerService();
//		System.out.println(customerService.deleteCustomerById(7));
		
		
		//=====>Update Customer
//		CustomerService customerService = new CustomerService();
//		customer.setName("Swastik");
//		System.out.println(customerService.updateCustomerById(customer));

		
		
		//=====>Retrieve All Data
//		CustomerService customerService = new CustomerService();
//		customerService.getCustomerALL();
		
		
		//=====>Retrieve Data by ID
		CustomerService customerService = new CustomerService();
		System.out.println(customerService.getCustomerById(2));
	}

}
