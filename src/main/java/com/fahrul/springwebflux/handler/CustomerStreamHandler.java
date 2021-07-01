package com.fahrul.springwebflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fahrul.springwebflux.dao.CustomerDao;
import com.fahrul.springwebflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

	@Autowired
	private CustomerDao customerDao;

	public Mono<ServerResponse> getCustomers(ServerRequest request) {
		Flux<Customer> customerStream = customerDao.getCustomerStream();
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(customerStream, Customer.class);
	}

}
