package com.vg.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vg.customermamangement.domain.Customer;
import com.vg.customermanagement.service.CustomerOperationService;
import com.vg.cutomermanagement.response.OperationResponseDto;
import com.vg.cutomermanagement.response.OperationResponseDto.Status;

@Controller
@RequestMapping("/customermanagement")
public class CustomerController {
		
	@Autowired
	CustomerOperationService operationService;
	
	@RequestMapping(value="/customers", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody OperationResponseDto<Status, Customer> addCustomer(@RequestBody Customer customer ){		
        return operationService.addNewCustomer(customer);
    }
	
	@RequestMapping(value="/customers", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Customer> getCustomers(){		
        return operationService.getCustomers();
    }
	
	@RequestMapping(value="/customers/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody OperationResponseDto<Status, Long> removeCustomer(@PathVariable("id") Long id){		
		return operationService.deleteCustomer(id);
    }


}

