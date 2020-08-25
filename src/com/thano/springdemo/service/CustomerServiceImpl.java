package com.thano.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thano.springdemo.dao.CustomerDAO;
import com.thano.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// we need to inject customer dao as our service depends on it
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// delegate call to dao
		return customerDAO.getCustomers();
	}

}
