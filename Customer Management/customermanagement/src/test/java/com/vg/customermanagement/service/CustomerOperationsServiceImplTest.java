package com.vg.customermanagement.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.vg.customermamangement.domain.Customer;
import com.vg.customermanagement.service.CustomerOperationsServiceImpl;
import com.vg.cutomermanagement.response.OperationResponseDto;
import com.vg.cutomermanagement.response.OperationResponseDto.Status;

@RunWith(MockitoJUnitRunner.class)
public class CustomerOperationsServiceImplTest {
	
	@InjectMocks
	private CustomerOperationsServiceImpl customerOperationsServiceImpl;
	

	@Test
	public void testGetCustomers() { 		 
		List<Customer> customers = customerOperationsServiceImpl.getCustomers();
		assertEquals(3, customers.size());
	 
		assertEquals(1L, customers.get(0).getId().longValue());
		assertEquals("Sherry", customers.get(0).getFirstname());
		assertEquals("Palmer", customers.get(0).getSurname());
	 
		assertEquals(2L, customers.get(1).getId().longValue());
		assertEquals("Paul", customers.get(1).getFirstname());
		assertEquals("Audrey", customers.get(1).getSurname());
	 
		assertEquals(3L, customers.get(2).getId().longValue());
		assertEquals("Amanda", customers.get(2).getFirstname());
		assertEquals("Joseph", customers.get(2).getSurname());		 
	}
	
	@Test
	public void testAddNewCustomerSuccess() {
		Customer customer = new Customer(null, "Mandy", "Scott");
		OperationResponseDto<Status, Customer> response = customerOperationsServiceImpl.addNewCustomer(customer);
		
		assertEquals(1L, response.getData().getId().longValue());
		assertEquals("Mandy", response.getData().getFirstname());
		assertEquals("Scott", response.getData().getSurname());
		
		assertEquals(Status.SUCCESS, response.getStatus());		 
	 
	 }
	
	@Test
	public void testAddNewCustomerError() {
		Customer customer = new Customer(null, "", "Scott");
		OperationResponseDto<Status, Customer> response = customerOperationsServiceImpl.addNewCustomer(customer);
		
		assertEquals(null, response.getData());	
		assertEquals(Status.FIRST_NAME_NOT_PRESENT, response.getStatus());	 
	 }
	
	@Test
	public void testDeleteCustomerSuccess() {
		OperationResponseDto<Status, Long> response = customerOperationsServiceImpl.deleteCustomer(2L);
		
		assertEquals(2L, response.getData().longValue());			
		assertEquals(Status.SUCCESS, response.getStatus());		 
	 
	 }
	
	@Test
	public void testDeleteCustomerError() {
		OperationResponseDto<Status, Long> response = customerOperationsServiceImpl.deleteCustomer(10L);
		
		assertEquals(10L, response.getData().longValue());			
		assertEquals(Status.ERROR, response.getStatus());		 
	 }


}
