package com.seleniumexpress.demo.router;

import java.time.Duration;

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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class HelloRouter {
	
	@Bean
	RouterFunction<ServerResponse> routerConfig(){
		
		RequestPredicate request = RequestPredicates.GET("/helloroute");
		
		HandlerFunction<ServerResponse> handlerFunction = new HandlerFunction<ServerResponse>() {

			@Override
			public Mono<ServerResponse> handle(ServerRequest request) {
				Flux<String> dataPublisher = Flux.just("hello","world","hi","reactive stream");
				
				Mono<ServerResponse> serverResponse = ServerResponse.ok().body(dataPublisher, String.class);
				return serverResponse;
			}
			
		};
		
		RouterFunction<ServerResponse> routerFunction = RouterFunctions.route(request, handlerFunction);
		return routerFunction;
		
	}

}
