package com.thano.springdemo.dao;

import java.util.List;

import com.thano.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer); 
	
}
