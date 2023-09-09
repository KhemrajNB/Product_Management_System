package com.jsp.controller;

import com.jsp.dto.Product;

import service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		Product product = new Product();
		product.setId(5);
		product.setName("P6");
		product.setPrice(190);
		product.setStock(34);
		
		
		//=====>Save Customer
//		ProductService productService = new ProductService();
//		Product p =  productService.saveProduct(product);
//		if(p!=null) {
//			System.out.println(p.getName()+" saved successfully");
//		}
		
		
		
		//=====>Delete Student
//		ProductService productService = new ProductService();
//		System.out.println(productService.deleteCustomerById(6));
		
		
		//=====>Update Customer
//		ProductService productService = new ProductService();
//		product.setName("abc");
//		System.out.println(productService.updateProductById(product));

		
		
		//=====>Retrieve All Data
//		ProductService productService= new ProductService();
//		productService.getProductALL();
		
		
		//=====>Retrieve Data by ID
		ProductService productService= new ProductService();
		System.out.println(productService.getProductById(2));

	}

}
