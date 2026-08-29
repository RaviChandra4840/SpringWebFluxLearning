package com.seleniumexpress.demo.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {

	public Mono<ServerResponse> hellohandler() {
		Flux<String> dataPublisher = Flux.just("hello","world","hi","reactive stream");
		
		Mono<ServerResponse> serverResponse = ServerResponse.ok().body(dataPublisher, String.class);
		return serverResponse;
	}
}
