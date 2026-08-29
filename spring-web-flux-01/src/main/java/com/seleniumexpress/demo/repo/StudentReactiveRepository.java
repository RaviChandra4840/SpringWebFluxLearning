package com.seleniumexpress.demo.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.seleniumexpress.demo.model.Student;

import reactor.core.publisher.Flux;

public interface StudentReactiveRepository extends ReactiveCrudRepository<Student,Integer>{
	
	@Query("select sleep(1),id,name,age from student;")
	Flux<Student> findAllStudents();

}
