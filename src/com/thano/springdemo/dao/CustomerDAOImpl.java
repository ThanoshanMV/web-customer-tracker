package com.thano.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thano.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		// execute the query and get result set
		List<Customer> customers = theQuery.getResultList();
		
		// return the customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save or update the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get customer from database based on primary key 
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

}
