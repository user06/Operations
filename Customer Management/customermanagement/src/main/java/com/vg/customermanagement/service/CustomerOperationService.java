package com.vg.customermanagement.service;

import java.util.List;

import com.vg.customermamangement.domain.Customer;
import com.vg.cutomermanagement.response.OperationResponseDto;
import com.vg.cutomermanagement.response.OperationResponseDto.Status;

public interface CustomerOperationService {
	/*
	 * This method adds a new Customer
	 * @param customer customer object containing firstname and surname
	 * 
	 * @returns OperationResponseDto containing the status of the add operation 
	 * and the customer object that was created
	 */
	public OperationResponseDto<Status, Customer> addNewCustomer(Customer customer);
	
	
	/*
	 * This method gets the list of all the customers	
	 * @returns list of customers
	 */
	public List<Customer> getCustomers();
	
	
	/*
	 * This method deletes the customer given its id
	 * 
	 */
	public OperationResponseDto<Status, Long> deleteCustomer(Long id);
	
	
}
