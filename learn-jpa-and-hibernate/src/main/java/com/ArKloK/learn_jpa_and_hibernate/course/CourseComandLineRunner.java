package com.ArKloK.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ArKloK.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJPARepository;

@Component
public class CourseComandLineRunner implements CommandLineRunner {

//	@Autowired
//	CourseJDBCRepository repository;
	
//	@Autowired
//	CourseJPARepository repository;
	
	@Autowired
	private CourseSpringDataJPARepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS", "carlos"));
		repository.save(new Course(2, "Learn DevOps", "carlos"));
		repository.save(new Course(3, "Learn React", "carlos"));
		repository.save(new Course(4, "Learn Vue", "carlos"));
		
		repository.deleteById(4l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(2l));
		
		System.out.println("Find all: " + repository.findAll());
		System.out.println("Count: " + repository.count());
		System.out.println("Find by name: " + repository.findByName("Learn AWS"));
		System.out.println("Find by author: " + repository.findByAuthor("carlos"));
	}

}
