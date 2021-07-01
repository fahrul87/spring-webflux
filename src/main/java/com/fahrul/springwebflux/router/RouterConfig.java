package com.fahrul.springwebflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fahrul.springwebflux.handler.CustomerHandler;
import com.fahrul.springwebflux.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {

	@Autowired
	private CustomerHandler customerHandler;

	@Autowired
	private CustomerStreamHandler customerStreamHandler;

	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route().GET("/router/customers", customerHandler::loadCustomers)
				.GET("/router/customer/stream", customerStreamHandler::getCustomers)
				.GET("/router/customer/{input}", customerHandler::findCustomer)
				.GET("/router/customer/save", customerHandler::saveCustomer).build();
	}

}
