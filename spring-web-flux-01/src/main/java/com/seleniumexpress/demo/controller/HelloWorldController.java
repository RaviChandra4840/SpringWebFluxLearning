package com.seleniumexpress.demo.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloworldhandler() {
		return "Helloworld";
	}
	
	@GetMapping("/fluxexample")
	public Flux<String> fluxString() throws InterruptedException {
		List<String> stringList = List.of("hello","world","hi","eeryone");
		Flux<String> pulisher = Flux.fromIterable(stringList).delayElements(Duration.ofSeconds(2)).log();
		return pulisher;
	}
	
	@GetMapping("/monoexample")
	public Mono<String> monoStirng(){
		Mono<String> publisher = Mono.just("JHON").log();
		return publisher;
		
	}
}
