package com.fahrul.springwebflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahrul.springwebflux.dao.CustomerDao;
import com.fahrul.springwebflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public List<Customer> loadAllCustomer() {
		Long start = System.currentTimeMillis();
		List<Customer> customers = customerDao.getCustomers();
		Long end = System.currentTimeMillis();
		System.out.println("Total execution time : " + (end - start));
		return customers;
	}

	public Flux<Customer> loadAllCustomerStream() {
		Long start = System.currentTimeMillis();
		Flux<Customer> custumers = customerDao.getCustomerStream();
		Long end = System.currentTimeMillis();
		System.out.println("Total execution time : " + (end - start));
		return custumers;
	}

}
