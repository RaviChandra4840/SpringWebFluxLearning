package com.seleniumexpress.demo.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.seleniumexpress.demo.model.Student;

public interface StudentReactiveRepository extends ReactiveCrudRepository<Student,Integer>{

}
