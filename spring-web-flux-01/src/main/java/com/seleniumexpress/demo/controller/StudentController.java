package com.seleniumexpress.demo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpress.demo.model.Student;
import com.seleniumexpress.demo.service.StudentService;

import reactor.core.publisher.Flux;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> getTotalStudents(){
		
		return studentService.getAllStudents();
	}

	
}
