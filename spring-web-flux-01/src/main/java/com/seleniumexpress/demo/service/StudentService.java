package com.seleniumexpress.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.demo.model.Student;
import com.seleniumexpress.demo.repo.StudentReactiveRepository;

import reactor.core.publisher.Flux;

@Service
public class StudentService {
	
	@Autowired
	private StudentReactiveRepository studentrepo;
	
	public Flux<Student> getAllStudents(){
		return studentrepo.findAll();
	}

}
