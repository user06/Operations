package com.vg.customermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vg.customermamangement.domain.Customer;
import com.vg.customermanagement.exceptions.CmException;
import com.vg.cutomermanagement.response.OperationResponseDto;
import com.vg.cutomermanagement.response.OperationResponseDto.Status;

@Service
public class CustomerOperationsServiceImpl implements CustomerOperationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOperationsServiceImpl.class);
	
	@Override
	public OperationResponseDto<Status, Customer> addNewCustomer(Customer customer) {
		// Perform any validations required
		if (StringUtils.isBlank(customer.getFirstname())) {
			return new OperationResponseDto<Status, Customer>(Status.FIRST_NAME_NOT_PRESENT, null);
		}
		
		Customer newCustomer = new Customer();
		
		// Could have done with in-memory database for demo purposes, but as the exercise says 
		// there is no need for database, I am just returning the customer object with id set.
		
		// In real life, I would be mapping the passed customer data to a customer entity 
		// and then calling dao method to persist the entity to the database. I would use
		// sequence to generate the ids.
		// As the exercise says there is no need to persist the data, I am just 
		// returning the customer object with id set.
		
		newCustomer.setFirstname(customer.getFirstname());
		newCustomer.setSurname(customer.getSurname());
		newCustomer.setId(1L);
		
		return new OperationResponseDto<Status, Customer>(Status.SUCCESS, newCustomer);
	}
	
	
	@Override
	public List<Customer> getCustomers() {
		// Could have done with in-memory database for demo purposes, but as the exercise says 
		// there is no need for database, I am just returning the hard-coded list of customers.
		
		// In real life, I would be calling the dao method to get the data from the database table
		
		List<Customer> customers = new ArrayList<>();
		customers.add(getCustomerOne());
		customers.add(getCustomerTwo());
		customers.add(getCustomerThree());
		
		
		return customers;
	}
	
	@Override
	public OperationResponseDto<Status, Long> deleteCustomer(Long id) {
		// Could have done with in-memory database for demo purposes, but as the exercise says 
		// there is no need for database, for the purposes of this exercise, I am assuming that deleting customer 
		// with id 10 results in constraint getting violated and an exception is thrown.
		
		// In real life, I would be calling the dao method to delete the data from the database table
		
		try {
			if (id.longValue() == 10L) {
				String msg = "Customer Id 10 is being referenced by another table";
				LOGGER.error(msg);
				throw new CmException(msg);
			}
		}
		catch(Exception ex) {
			return new OperationResponseDto<Status, Long>(Status.ERROR, id);
		}
				
		return new OperationResponseDto<Status, Long>(Status.SUCCESS, id);	
	}
	
	private Customer getCustomerOne() {
		return new Customer(1L, "Sherry", "Palmer");		
	}
	
	private Customer getCustomerTwo() {
		return new Customer(2L, "Paul", "Audrey");		
	}
	
	private Customer getCustomerThree() {
		return new Customer(3L, "Amanda", "Joseph");		
	}
	
}
