package com.seleniumexpress.demo.router;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.seleniumexpress.demo.handler.HelloHandler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class HelloRouter {
	
	@Autowired
	private HelloHandler helloHandler;
	
	@Bean
	RouterFunction<ServerResponse> routerConfig(){
		
		RouterFunction<ServerResponse> routerFunction = RouterFunctions.route(RequestPredicates.GET("/helloroute"), request -> helloHandler.hellohandler());
		return routerFunction;
		
	}

}
