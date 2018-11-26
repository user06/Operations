package com.vg.customermanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.vg.customermamangement.domain.Customer;
import com.vg.customermanagement.service.CustomerOperationService;
import com.vg.cutomermanagement.response.OperationResponseDto;
import com.vg.cutomermanagement.response.OperationResponseDto.Status;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	@InjectMocks
	private CustomerController controller;
	
	@Mock
	private CustomerOperationService mockOperationService;
	

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer(null, "Mandy", "Scott");
		Customer customerAfterAdd = new Customer(1L, "Mandy", "Scott");
		OperationResponseDto<Status, Customer> expectedResponse = new OperationResponseDto<Status, Customer>(Status.SUCCESS, customerAfterAdd);
		when(mockOperationService.addNewCustomer(customer)).thenReturn(expectedResponse);

		OperationResponseDto<Status, Customer> response = controller.addCustomer(customer);

		assertEquals(expectedResponse, response);
		verify(mockOperationService, times(1)).addNewCustomer(customer);	 
	}
	
	@Test
	public void testGetCustomers() {
		List<Customer> expectedResponse = getAllCustomers();
		when(mockOperationService.getCustomers()).thenReturn(expectedResponse);

		List<Customer> response = controller.getCustomers();

		assertEquals(expectedResponse, response);
		verify(mockOperationService, times(1)).getCustomers();	 
	 
	 }
	
	@Test
	public void testRemoveCustomer() {
		OperationResponseDto<Status, Long> expectedResponse = new OperationResponseDto<Status, Long>(Status.SUCCESS, 2L);
		when(mockOperationService.deleteCustomer(2L)).thenReturn(expectedResponse);

		OperationResponseDto<Status, Long> response = controller.removeCustomer(2L);

		assertEquals(expectedResponse, response);
		verify(mockOperationService, times(1)).deleteCustomer(2L);	 
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
	
	private List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(getCustomerOne());
		customers.add(getCustomerTwo());
		customers.add(getCustomerThree());
		
		return customers;
	}


}

