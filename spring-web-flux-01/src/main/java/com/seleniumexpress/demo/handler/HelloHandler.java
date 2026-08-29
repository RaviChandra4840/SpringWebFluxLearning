package com.seleniumexpress.demo.handler;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {

	public Mono<ServerResponse> hihandler() {
		
		Flux<String> dataPublisher = Flux.just("hello","world","hi","reactive stream").delayElements(Duration.ofSeconds(1));
		Mono<ServerResponse> serverResponse = ServerResponse.ok().body(dataPublisher, String.class);
		return serverResponse;
	}
	
	public Mono<ServerResponse> helloPlaceholder(ServerRequest serverRequest) {
		
		String name = serverRequest.pathVariable("yourName");
		String response = "Your name is : "+ name;
		Mono<String> finalresponse = Mono.just(response);
		return ServerResponse.ok().body(finalresponse, String.class);
		
	}
}
