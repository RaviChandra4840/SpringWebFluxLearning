package com.seleniumexpress.demo.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.seleniumexpress.demo.handler.HelloHandler;

@Configuration
public class HelloRouter {
	
	@Autowired
	private HelloHandler helloHandler;
	
	@Bean
	RouterFunction<ServerResponse> routerConfig(){
		
		return RouterFunctions.route(RequestPredicates.GET("/hi/{yourName}"), helloHandler::helloPlaceholder);
		
	}
	
	

}
